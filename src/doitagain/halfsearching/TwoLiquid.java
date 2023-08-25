package doitagain.halfsearching;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TwoLiquid {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력값
        int N = Integer.parseInt(br.readLine());

        String[] secondLine = br.readLine().split(" ");
        Long arr[] = new Long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(secondLine[i]);
        }

        // 정렬
        Arrays.sort(arr);

        // 출력을 위한 변수 선언
        long num1= 0;
        long num2= 0;
        long lowestValue = 2000000000;

        //반복문 실행
        for(int i=0; i<N-1; i++){

            long pairValue = findPairValue(i+1, N-1, arr, arr[i]);
            long sum = Math.abs(arr[i] + pairValue);

            if(lowestValue > sum){
                lowestValue = sum;
                num1 = arr[i];
                num2 = pairValue;
            }
        }

        bw.write(num1 + " " + num2);
        bw.flush();
    }

    // 이분탐색
    public static long findPairValue(int a, int b, Long arr[], long target){
        long checkValue = 2000000000;

        int leftIndex = a;
        int rightIndex = b;
        long pairValue = 0;
        long abs = 0;

        while(leftIndex <= rightIndex){

            long sum = 0;

            int m = (leftIndex + rightIndex) / 2;
            sum =  target + arr[m];
            abs = Math.abs(sum);
            if(abs < checkValue){
                checkValue = abs;
                pairValue = arr[m];
            }
            if(sum < 0){
                leftIndex = m+1;
            }else if(sum > 0){
                rightIndex = m-1;
            }else{
                return arr[m];
            }
        }

            return  pairValue;

    }
}
