package DynamicPrograming;

import java.io.*;

public class OneTwoThree3 {

    /**
     *     100 만 까지 진행하려면 완전탐색으로 하기에는 값이 너무 크다.
     *      가짜 문제를 만들어보자.
     *      dp[i] :: i 를 1,2,3으로 나타낼 수 있는 방법의 수
     *      이 문제를 풀면 정답을 구할 수 있나 ? dp[N] O
     *      초기값
     *      점화식 구하기.
     *      dp[1] : 1 (1)
     *      dp[2] : 2 (1,1 / 2)
     *      dp[3] : 4  (1,1,1 / 1,2 / 2,1 / 3)
     *      dp[4] : 7 (1,1,1,1 / 1,1,2 / 1,2,1 / 2,1,1 / 1,3 / 3,1 / 2,2 )
     */

    static int T,N;
    static long[] dp;

    public static void dp_func(){
        dp = new long[1000005];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;

        for(int i=4; i<=1000000; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        dp_func();

        while(T--> 0){
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }

        bw.flush();
    }

}
