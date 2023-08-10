package PartSum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Annoying {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        if(N>0){

            int inputArr [] = new int[N+1];
            for(int i=1; i<=N; i++){
                inputArr[i] = sc.nextInt();
            }

            // 구간 합
            int acc[] = new int[N+1];
            for(int i=1; i<=N; i++){
                acc[i] = acc[i-1] + inputArr[i];
            }

            // 출력
            long ans = 0;

            for(int i=1; i<N; i++){
                ans += inputArr[i] * (acc[N] - acc[i]);
            }

            System.out.println(ans);

        }

    }
}
