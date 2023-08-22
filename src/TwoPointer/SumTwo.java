package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumTwo {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;
        int rightIndex = 0;
          // 투 포인터

        for(int i=0; i<N; i++){
            while(sum < M && rightIndex < N){
                sum += arr[rightIndex++]; // rightIndex 역할
            }
            if(sum == M){
                count ++;
            }
            sum -= arr[i]; //leftIndex 역할
        }

        System.out.println(count);
    }
}
