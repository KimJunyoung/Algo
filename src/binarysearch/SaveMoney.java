package binarysearch;

import java.io.*;
import java.util.Scanner;

public class SaveMoney {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 이분탐색 시작
        int l = 0, r = N * 10000 , check = -1;
        while(l<=r){
            int m = (l+r) / 2 ;

            if(isItRight(arr, m, R)){
                r = m-1;
                check = m;
            }else{
                l = m+1;
            }
        }


        bw.write(check + "");
        bw.flush();
    }

    public static boolean isItRight(int arr[], int m, int Q){
        int count = 1;
        int remain = m;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > m) return false;
            if(arr[i] > remain){
                count ++;
                remain = m;
            }
            remain -= arr[i];
        }
        return Q >= count;
    }

}
