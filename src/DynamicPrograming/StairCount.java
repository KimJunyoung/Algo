package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StairCount {

    static int N;
    static long[][] dp;

    public static void dp_func(){
        dp[10][0] = 1;

        for(int i=11; i<=100; i++){
            for(int j=0; j<10; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1];
                } else if(j == 9){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
    }

    public static void pro() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new long[105][10];

    }

    public static void main(String[] args) throws FileNotFoundException {
        pro();
        dp_func();
        long ans = 0;
        for(int i=0; i<=9; i++){
            ans += dp[N][i];
        }
        System.out.println(ans % 1000000000);
    }
}
