/*** main.cpp ***/
#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <stdio.h>

#define CMD_SUM 1
#define CMD_SUB 2
#define CMD_MUL 3
#define CMD_DIV 4


/////////////////////////////////////////////////////////////////////////

extern int sum(int A, int B);
extern int sub(int A, int B);
extern int mul(int A, int B);
extern int div(int A, int B);

/////////////////////////////////////////////////////////////////////////

static bool run() {

    int numQuery;
    int cal;
    int A, B;
    int userAns, ans;
    bool isCorrect = true;

    scanf("%d", &numQuery);

    for (int i = 0; i < numQuery; ++i) {
        scanf("%d %d %d %d", &cal, &A, &B, &ans);
        if (cal == CMD_SUM) {
            userAns = sum(A, B);
            if (userAns != ans)isCorrect = false;
        }
        if (cal == CMD_SUB) {
            userAns = sub(A, B);
            if (userAns != ans)isCorrect = false;
        }
        if (cal == CMD_MUL) {
            userAns = mul(A, B);
            if (userAns != ans)isCorrect = false;
        }
        if (cal == CMD_DIV) {
            userAns = div(A, B);
            if (userAns != ans)isCorrect = false;
        }
    }
    return isCorrect;
}

int main() {
    setbuf(stdout, NULL);
    // freopen("input.txt", "r", stdin);

    int T, MARK;
    scanf("%d %d", &T, &MARK);

    for (int tc = 1; tc <= T; tc++) {
        int score = run() ? MARK : 0;
        printf("#%d %d\n", tc, score);
    }

    return 0;
}
