package PartSum;

import java.io.*;
import java.util.Scanner;

public class GenericQueries {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int inputArr [] = new int[N+1];

        for(int i=1; i<=N;i++){
            inputArr[i] = sc.nextInt();
        }

        int xorArr [] = new int[N+1];

        for(int i=1; i<= N; i++){
            xorArr[i] = xorArr[i-1] ^ inputArr[i];
        }

        int ans = 0;
        while(Q-- >0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            ans ^= xorArr[j] ^ xorArr[i-1];
        }
        System.out.println(ans);


    }
}
