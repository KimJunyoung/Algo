package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SortCards {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        int N = sc.nextInt();
        long arr[] = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 값들을 저장하면서 나가는 변수
        long sum = 0L;

        long arrSum[] = new long[N+1];
        addSum(arrSum, arr);

        for (long l : arrSum) {
            System.out.print(" " + l);
        }

        long sum1 = Arrays.stream(arrSum).sum();
        System.out.println(sum1 - arr[1]);
    }

    static void addSum(long[] arrSum, long[] arr){
        for(int i=1; i<= arrSum.length-1; i++){
            arrSum[i] = arr[i] + arrSum[i-1];
        }
    }

}
