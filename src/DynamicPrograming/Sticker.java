package DynamicPrograming;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 최댓값을 구하는 것이므로 dp[][]  이다.
 * 일단 dp[i] :: 2* i 개의 스티커가 있을 때 낼 수 있는 최고점수
 * dp[N] 정답 O
 * 초기 값
 * dp[1] = 50
 * dp[2] = 100 [ 1, 2 ]
 * dp[3] = 200 [1, 2, 1]
 * dp[4] = 260 [1,2,1,2]
 * dp[5] = 260 [1,2,1, _ , 2]
 * 경우의수
 *  [1, 2, 1, 2, 1] [1,2,1,_2] [1,2,_1,2]
 *  부족한 조건 :
 *  1. 마지막 앞에서 건너 뛰었냐 안건너 뛰었냐 dp[i-1] dp[i-2]
 *  2. 전에 값이 위냐 아래냐 (dp[0] , dp[1] )
 */

public class Sticker {

    static int T,N;
    static int[][] dp;
    static int[][] A;

    public static void dp_func() {
        dp[0][1] = A[0][1];
        dp[1][1] = A[1][1];

        for(int i = 2; i<=N; i++){
            dp[0][i] = Math.max(dp[1][i-1] , dp[1][i-2]) + A[0][i];
            dp[1][i] = Math.max(dp[0][i-1] , dp[0][i-2]) + A[1][i];
        }

        System.out.println(Math.max(dp[0][N] , dp[1][N]));
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        while(T-->0){
             N = sc.nextInt();
            A = new int[2][N+1];
            dp = new int[2][N+1];
            for(int i=0;i<2;i++){
                for(int j=1; j<=N; j++){
                    A[i][j] = sc.nextInt();
                }
            }
            dp_func();
        }
    }
}
