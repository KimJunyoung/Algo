package doitagain.twopointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumbersSum {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 투포인터 알고리즘

        //왼쪽 포인터는 반복문 안에서 index인 i가 담당, 오른쪽은 rightIndex
        int count = 0;
        int sum = 0;
        int rightIndex = 0;

        for(int i=0; i<N; i++){
            while(sum < M && rightIndex < N){
                sum += arr[rightIndex++];
            }

            if(sum == M){
                count ++;
            }

            sum -= arr[i];
        }

        System.out.println(count);
    }
}
