package DynamicPrograming;

import java.io.*;
import java.util.Scanner;

public class TwoTile {

    static int N ;
    static int[] dp;

    public static void dynamic(){
        dp = new int[1005];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<=1000; i++){
            // 계속 돌리다보면 dp[i] 값 자체가 int 범위를 넘어선다. 그래서 계속해서 모듈러 연산을 해줘야한다.
            dp[i] = ( dp[i-1] + dp[i-2] ) % 10007;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dynamic();

        bw.write(dp[N] + "");
        bw.flush();

    }
}
