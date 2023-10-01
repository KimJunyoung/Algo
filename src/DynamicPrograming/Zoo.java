package DynamicPrograming;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * dp[i][0] dp[i][1] 을 두개 더하면 dp[N] 을 통해 정답을 구할 수 있다.
 * 초기값
    dp[1] = 0 / 1,0 1,1
    dp[2] =0 / 1,0 1,1 2,0 2,1 / (1,0 2,1) (1,1 2,0)
    partition
    안고르는 경우 0 / 1,0 1,1
    1번으로 깥나는 경우 2,0 (1.1 2.0)
    2번으로 끝나는 경우 2.1 (1.0 2.1)
    dp[3] = 0 / 1,0 1,1 2,0 2,1 3,0 3.1 / (1.0 2.1 ) (1.0 3.0) (1.0 3.1)  (1.1 2.0) (1.1 3.0) (1.1 3.1)  (2.1 3.0) (2.0 3.1)  / (1.0 2.1 3.0) (1.1 2.0 3.1)
    partition
    안고르는 경우 0 / 1,0 1,1 2,0 2,1 /  (1.0 2.1 )  (1.1 2.0)
    1번으로 끝나는 경우 3,0 /  (1.0 3.0) (1.1 3.0)  (2.1 3.0) /  (1.0 2.1 3.0)
    2번으로 끝나는 경우 3,1 /  (1.0 3.1)  (1.1 3.1)  (2.0 3.1) / (1.1 2.0 3.1)
 */
public class Zoo {

    static int N;
    static long[][] dp;

    public static void dp_func(){
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2] ) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] ) % 9901;


        }
    }

    public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new long[N+1][3];
        dp_func();
        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        System.out.println(ans);
    }
}
