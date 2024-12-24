import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class UserSolution {

    static class Potato implements Comparable<Potato>{
        int y;
        int x;
        int cost;
        Potato(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public int compareTo(Potato o) {
            if(cost > o.cost) return -1;
            if(cost < o.cost) return 1;
            if(y < o.y) return -1;
            if(y > o.y) return 1;
            if(x < o.x) return -1;
            if(x > o.x) return 1;
            return 0;
        }
    }

    static int[][] MAP;
    static int[][] cost;
    static int size;
    static int[] cnt;

    static int num;

    static int[] ydir = {-1, 1, 0, 0};
    static int[] xdir = {0, 0, -1, 1};

    static int[][] visited;

    public void init(int N, int mField[][])
    {
        cost = mField;
        size = N;
        MAP = new int[N][N];
        visited = new int[N][N];
        cnt = new int[3]; // 1, 2박테리아
        num = 0;
    }

    public int dropSeed(int mType, int mRow, int mCol, int mEnergy)
    {
        int y = mRow - 1;
        int x = mCol - 1;
        int target = mType;
        int energy = mEnergy;

        if(MAP[y][x] != mType && MAP[y][x] != 0)
            return cnt[mType];

        else if(MAP[y][x] == 0) {
            cnt[target]++;
            energy -= cost[y][x];
            MAP[y][x] = target;
        }

        ArrayDeque<Potato>q = new ArrayDeque<>();
        q.add(new Potato(y, x, 0));
        PriorityQueue<Potato>pq = new PriorityQueue<>();

        num++;
        visited[y][x] = num;

        while(energy > 0) {
            while(!q.isEmpty()) {
                Potato now = q.removeFirst();
                for(int i = 0; i < 4; i++) {
                    int ny = now.y + ydir[i];
                    int nx = now.x + xdir[i];
                    if(ny < 0 || nx < 0 || ny >= size || nx >= size)
                        continue;
                    if(visited[ny][nx] == num)
                        continue;
                    if(MAP[ny][nx] != 0 && MAP[ny][nx] != target)
                        continue;

                    visited[ny][nx] = num;

                    if(MAP[ny][nx] == 0) {
                        pq.add(new Potato(ny, nx, cost[ny][nx]));
                    }
                    if(MAP[ny][nx] == target) {
                        q.addLast(new Potato(ny, nx, 0));
                    }
                }
            }
            if(pq.isEmpty())
                break;

            Potato activate = pq.remove();
            MAP[activate.y][activate.x] = target;
            cnt[target]++;

            q.addLast(activate);
            energy -= activate.cost;
        }

        return cnt[target];
    }

    public int dropPotion(int mRow, int mCol)
    {
        int y = mRow - 1;
        int x = mCol - 1;

        int target = MAP[y][x];

        if(target == 0)
            return -1;

        ArrayDeque<Potato>q = new ArrayDeque<>();
        q.addLast(new Potato(y, x, 0));

        MAP[y][x] = 0;
        int bcnt = 1;

        while(!q.isEmpty()) {
            Potato now = q.removeFirst();
            for(int i = 0; i < 4; i++) {
                int ny = now.y + ydir[i];
                int nx = now.x + xdir[i];
                if(ny < 0 || nx < 0 || ny >= size || nx >= size)
                    continue;
                if(MAP[ny][nx] != target)
                    continue;
                q.addLast(new Potato(ny, nx, 0));
                MAP[ny][nx] = 0;
                bcnt++;
            }
        }
        cnt[target] -= bcnt;
        return cnt[target];
    }
}
