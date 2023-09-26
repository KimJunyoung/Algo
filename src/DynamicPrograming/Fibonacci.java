package DynamicPrograming;

import java.io.*;
import java.util.Scanner;

public class Fibonacci {

    static int N, T;
    static int dp[][];

    public static void dynamic(){
        dp = new int[45][2];
        dp[0][0]  = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        dp[2][0] = 1;
        dp[2][1] = 1;

        for(int i=3; i<=40; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dynamic();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0] + " "  + dp[N][1] + '\n');
        }

        bw.flush();
    }
}
