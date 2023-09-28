package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OneTwoThree {

    static int T, N;
    static int[] dp;

    public static void dynamic(){
            dp = new int[1000005];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<= 1000000; i++){
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            }
    }

    public static void main(String[] args) throws FileNotFoundException {
         System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        dynamic();
        T = sc.nextInt();

        while(T-- > 0) {
            N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}
