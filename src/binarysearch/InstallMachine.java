package binarysearch;

import java.io.*;
import java.util.Arrays;

public class InstallMachine {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int C = Integer.parseInt(firstLine[1]);

        long arr[] = new long[N];

        for(int i=0; i<N; i++){
            arr[i]  = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        // 저장할 변수값
        long l = 0L, r = 1000000000, check = -1;

        while(l<=r){
            long m = (l + r) / 2;
            if(isPossible(arr, C, m)){
                l = m+1;
                check = m;
            }else{
                r = m-1;
            }
        }

        bw.write(check + "");
        bw.flush();
    }

    public static boolean isPossible(long arr[], int c, long m){
        int count = 1;
        long indexValue = arr[0];

        for(int i=1; i< arr.length; i++){

            if(arr[i] - indexValue < m){
                continue;
            }
            if(arr[i] - indexValue >= m){
                count ++;
                indexValue = arr[i];
            }

        }

        if(count < c){
            return false;
        }

        return true;
    }
}
