/*** main.cpp ***/
#define _CRT_SECURE_NO_WARNINGS
#ifndef _CRT_SECURE_NO_WARNINGS
#endif
 
#include <stdio.h>
 
#define MAX_N 100
 
extern void init(int N, int mField[MAX_N][MAX_N]);
extern int dropSeed(int mType, int mRow, int mCol, int mEnergy);
extern int dropPotion(int mRow, int mCol);
 
#define CMD_INIT 100
#define CMD_DROP_SEED 200
#define CMD_DROP_POTION 300
 
static bool run()
{
    int query_num;
    scanf("%d", &query_num);
 
    int ret, ans;
    bool ok = false;
    static int field[MAX_N][MAX_N];
 
    for (int q = 0; q < query_num; q++)
    {
        int query;
        scanf("%d", &query);
 
        if (query == CMD_INIT)
        {
            int N;
            scanf("%d", &N);
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    scanf("%d", &field[i][j]);
                }
            }
            init(N, field);
            ok = true;
        }
        else if (query == CMD_DROP_SEED)
        {
            int type;
            int row, col;
            int energy;
            scanf("%d %d %d %d", &type, &row, &col, &energy);
            ret = dropSeed(type, row, col, energy);
            scanf("%d", &ans);
            if (ans != ret)
            {
                ok = false;
            }
        }
        else if (query == CMD_DROP_POTION)
        {
            int row, col;
            scanf("%d %d", &row, &col);
            ret = dropPotion(row, col);
            scanf("%d", &ans);
            if (ans != ret)
            {
                ok = false;
            }
        }
    }
    return ok;
}
 
int main()
{
    setbuf(stdout, NULL);
    //freopen("input.txt", "r", stdin);
    int T, MARK;
    scanf("%d %d", &T, &MARK);
 
    for (int tc = 1; tc <= T; tc++)
    {
        int score = run() ? MARK : 0;
        printf("#%d %d\n", tc, score);
    }
    return 0;
}
