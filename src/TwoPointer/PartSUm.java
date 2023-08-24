package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartSUm {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값 받기
        int N = sc.nextInt();
        int S = sc.nextInt();

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 투포인터
        int rightIndex = 0;
        long sum = 0;
        int count = 0;
        long lowCount = 1000000000;

        for(int i=0; i<N; i++){

            while(sum < S && rightIndex < N){
                sum += arr[rightIndex++];
                count ++;
            }

            if(sum >= S){
                lowCount = Math.min(lowCount, count);
            }

            sum -= arr[i];
            count --;
        }

        if(lowCount == 1000000000){
            System.out.println(0);
        }else{
            System.out.println(lowCount);
        }



    }

}
