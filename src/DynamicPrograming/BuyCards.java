package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 가짜 문제 만들기
 * dp[i] :: i 개의 카드를 구매하기 위해 지불해야하는 금액의 최댓값
 * dp[N] O
 * 초기값
 * 점화식..
 */

public class BuyCards {

    static int N;
    static int[] arr, dp;

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        dp = new int[1005];

        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }
    }

    public static void dp_func(){
        /**
         * 초기값
         * dp[1] = 1
         * dp[2] = 5
         * dp[3] = 6
         * dp[4] = 10 [1 .....1] [1...2]
         *
         * dp[1] = 1
         * dp[2] = 2
         * dp[3] = 3 [1,1,1]
         * dp[4] = 4  [ 1, ,1, 1, ,1 ] /  [1, 1, 2]  [2 2]  /  [1,3] / [4]
         */
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i=2; i<=N; i++){
            int ans = 0;
            for(int j=1; j<i; j++){
                ans = Math.max(ans, (dp[i-j] + dp[j]));
            }
            dp[i] = Math.max(ans , arr[i]);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        dp_func();
        System.out.println(dp[N]);
    }
}
