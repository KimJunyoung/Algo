package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PTChoose {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        long arr[] = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextLong();
        }
        long checkNum =0;
        long max = 0;
        long sum = 0;

        Arrays.sort(arr);

        if(arr.length % 2 ==0){
            for(int i=0; i< (N/2); i++){
                sum = arr[i] + arr[N - i - 1];
                max = Math.max(sum, max);
            }
        }else {
            max = arr[N-1];
            for(int i=0; i< (N/2); i++){
                sum = arr[i] + arr[N - i - 2];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}
