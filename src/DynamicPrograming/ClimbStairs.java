package DynamicPrograming;

import java.io.*;

public class ClimbStairs {

    static int N;
    static int[] stairs;
    static int[][] dp;

    public static void dp_func(){
        dp[0][0] = 0;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = stairs[1];

        if(N >=2){
            dp[2][0] = stairs[2];
            dp[2][1] = stairs[1] + stairs[2];
        }

        for(int i=3; i<=N; i++){
            dp[i][0] = Math.max(dp[i-2][1] + stairs[i] , dp[i-2][0] + stairs[i]);
            dp[i][1] = dp[i-1][0] + stairs[i];
        }

    }

    public static void pro() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];

        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[305][2];

        dp_func();

        bw.write(Math.max(dp[N][0], dp[N][1]) +"");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
            pro();
    }
}
