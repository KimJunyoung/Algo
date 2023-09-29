package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoUp {

    /**
     * dp[i] :: i 의 자리가 오름차순을 이루는 수
     * dp[N] O
     * 초기값
     *  dp[1] = 10
     *  dp[2] = 55
     *  dp[3] = 220 규칙이라는게 보이지 않는다.
     *  추가적으로 필요한 정보는 무엇일까 ?
     *  dp[2]
     *  00 01 02 03 04 05 06 07 08 09 10
     *  11 12 13 14 15 16 17 18 19 9
     *  22 23 24 25 26 27 28 29 8
     * ....
     * dp[3]
     *  000 001 002 003 .... 009
     *  011 012 ... 019
     *
     * 111 112 113 114 115 116 117 118 119
     * 122 ...
     *
     * 222 ..
     *
     * 1111 1112 ...
     * 1999 는 111 ~ 999 까지 갯수
     * 전의 갯수들이 필요함.
     부족한 정보 :

     *  */

    static int N;
    static int[][] dp;
    static int[] A;

    public static void dp_func(){
        // 초기값

        for(int num = 0; num <= 9; num ++){
            dp[1][num] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[10010][10];
        dp_func();
        int ans = 0;
        for(int i=0; i<10; i++){
            ans += dp[N][i];
            ans %= 10007;
        }
        System.out.println(ans);
    }
}
