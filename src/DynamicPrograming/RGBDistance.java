package DynamicPrograming;

import java.io.*;

public class RGBDistance {

    static int N;
    static int[][] dp, arrInput;

    public static void dp_func(){
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i=1; i<=N; i++){
            dp[i][0] = Math.min(dp[i-1][1]  , dp[i-1][2] ) + arrInput[i][0];
            dp[i][1] = Math.min(dp[i-1][0]  , dp[i-1][2] ) + arrInput[i][1];
            dp[i][2] = Math.min(dp[i-1][0]  , dp[i-1][1] ) + arrInput[i][2];
        }
    }

    public static void input() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arrInput = new int[N+1][3];
        dp = new int[1005][3];
        for(int i=1;i<=N;i++) {
            String[] split = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                arrInput[i][j] = Integer.parseInt(split[j]);
            }
        }

        dp_func();

        int ans = Math.min(Math.min(dp[N][0], dp[N][1]) , dp[N][2]);
        bw.write(ans + "");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
            input();
    }
}
