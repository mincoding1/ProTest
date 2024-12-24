import java.io.*;
import java.util.*;

class Main {
    private final static int CMD_INIT 			= 100;
    private final static int CMD_DROPSEED 		= 200;
    private final static int CMD_DROPPOTION		= 300;
    private final static int MAX_N 				= 100;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception {

        StringTokenizer st;

        int Q;
        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());

        int userAns, ans;
        int N, row, col;
        int type, energy;
        boolean isCorrect = false;
        int[][] field = new int[MAX_N][MAX_N];
        int cmd;

        for (int q = 0; q < Q; ++q) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case CMD_INIT:
                    N = Integer.parseInt(st.nextToken());
                    for(int i = 0; i < N; i++) {
                        st = new StringTokenizer(br.readLine());
                        for(int j = 0; j < N; j++)
                            field[i][j] = Integer.parseInt(st.nextToken());
                    }
                    usersolution.init(N, field);
                    isCorrect = true;
                    break;
                case CMD_DROPSEED:
                    type = Integer.parseInt(st.nextToken());
                    row = Integer.parseInt(st.nextToken());
                    col = Integer.parseInt(st.nextToken());
                    energy = Integer.parseInt(st.nextToken());
                    userAns = usersolution.dropSeed(type, row, col, energy);
                    ans = Integer.parseInt(st.nextToken());
                    if(userAns != ans)
                        isCorrect = false;
                    break;
                case CMD_DROPPOTION:
                    row = Integer.parseInt(st.nextToken());
                    col = Integer.parseInt(st.nextToken());
                    userAns = usersolution.dropPotion(row, col);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans)
                        isCorrect = false;
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }
        return isCorrect;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}
