package TwoPointer;

import java.io.*;
import java.util.Arrays;

public class SelectNum {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 입력값
        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        long M = Long.parseLong(firstLine[1]);

        long arr[] = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        // 연속된 두 수가 아니기 때문에 수열을 정렬해도 됨.
        Arrays.sort(arr);


        // 투 포인터 사용을 위한 변수 선언
        long minusValue = 0 ;
        long minValue = 10000000001L;
        int rightIndex = 1;

        for(int i=0; i<N; i++){

            minusValue = Math.abs(arr[rightIndex-1] - arr[i]);

            while(Math.abs(minusValue) < M && rightIndex < N){
                minusValue = Math.abs(arr[rightIndex++] - arr[i]);
            }



            if(Math.abs(minusValue) >= M){
                minValue = Math.abs(Math.min(minValue,minusValue));
            }



            minusValue = 0;


        }

        bw.write(minValue + "");
        bw.flush();
    }
}
