package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberCard {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 저장
        int N = Integer.parseInt(br.readLine());

        // 첫쨰줄 , 둘째줄
        String arrSt[] = br.readLine().split(" ");
        int arrStToInt[] = new int[N];
        for(int i=0; i<N; i++){
            arrStToInt[i] = Integer.parseInt(arrSt[i]);
        }

        // 셋째줄, 넷째줄
        int M = Integer.parseInt(br.readLine());

        String arrSt2[] = br.readLine().split(" ");
        int arrStToInt2[] = new int[M];
        for(int i=0; i<M; i++){
            arrStToInt2[i] = Integer.parseInt(arrSt2[i]);
        }
        // 정렬
        Arrays.sort(arrStToInt);

        for(int i=0; i<M; i++){
            int lowerBoundIndex = findLowerBoundIndex(arrStToInt, arrStToInt2[i]);
            int upperBoundIndex = findUpperBoundIndex(arrStToInt, arrStToInt2[i]);
            System.out.print(upperBoundIndex - lowerBoundIndex + " ");
        }

    }

    static int findLowerBoundIndex(int[] arr, int x){
        int lowerBoundIndex = arr.length;
        int l = 0;
        int r =arr.length - 1;
        while(l <= r){
            int m = (l + r)/2;
            if(x <= arr[m]) {
                r = m - 1;
                lowerBoundIndex = m;
            } else {
                l = m+1;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x){
        int UpperBoundIndex = arr.length;
        int l = 0;
        int r =arr.length - 1;
        while(l <= r){
            int m = (l + r)/2;
            if(arr[m] <= x) {
                l = m+1;
            } else {
                r = m - 1;
                UpperBoundIndex = m;
            }
        }
        return UpperBoundIndex;
    }
}
