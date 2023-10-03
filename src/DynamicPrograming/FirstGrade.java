package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FirstGrade {

    static int N;
    static int[] arrInput;
    static long[][] dp;

    /**
     * 가짜 문제를 만들어보자
     * dp[i] :: i 번째 숫자까지 만들 수 있는 (조건에 부합하는) 갯수
     * dp[N] ? O
     * 8 3 2 4 8 7 2 4 0 8 8
     * dp[N][0] 은 + / dp[N][1] 은 - ?
     * dp[1][0] : 0
     * dp[2][0] : 11 dp[2][1] : 5
     * dp[3][0] : 13, 7 dp[3][1] :9, 5
     * dp[4][0] : /
     * dp[5] : 0
     * dp[6] :
     * 결국 전의 값들이 필요하다.
     */
    public static void dp_func(){
        dp[1][arrInput[1]] = 1;

        for(int i=2; i<=N-1; i++){
            for(int prev = 0; prev <=20; prev++){
                for(int cur : new int[]{prev + arrInput[i], prev - arrInput[i]}){
                    if(cur < 0 || cur > 20) continue;
                    dp[i][cur] += dp[i-1][prev];
                }
            }
        }
        System.out.println(dp[N-1][arrInput[N]]);
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new long[N+1][21];
        arrInput = new int[N+1];

        for(int i=1; i<=N; i++){
            arrInput[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        dp_func();
    }
}
