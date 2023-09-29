package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DontWannaGoDown {

    static int T,N;
    static long[][] dp;

    public static void dp_func(){
        dp = new long[N+1][10];
        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int start = 2; start <= N; start++){
            for(int num = 0; num <=9; num++){
                for(int i=0; i<=num; i++){
                    dp[start][num] += dp[start -1][i];
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while(T-- > 0){
            N = sc.nextInt();
            dp_func();
            long ans = 0;
            for(int i=0; i<=9; i++){
                ans += dp[N][i];
            }
            System.out.println(ans);
        }
    }
}
