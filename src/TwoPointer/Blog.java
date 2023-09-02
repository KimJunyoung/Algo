package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Blog {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int X = sc.nextInt();

        int intArray[] = new int[N];

        for(int i=0; i<N; i++){
            intArray[i] = sc.nextInt();
        }

        int rightIndex = 0;
        int sum = 0;
        int forCountSum = 0;
        // 기본 값 저장
        for(int i=0; i<X-1; i++){
            sum += intArray[i];
            forCountSum += intArray[i];
        }


        //최대 값
        int maxNum = -1;
        int count = 0;


        // 투포인터 반복문
        for(int i=X-1; i<N; i++){
            sum += intArray[i];
            maxNum = Math.max(maxNum, sum);
            sum -= intArray[i-X+1];
        }

        // 횟수
        for(int i=X-1; i<N; i++){
            forCountSum += intArray[i];
            if(forCountSum == maxNum) count++;
            forCountSum -= intArray[i-X+1];
        }


        if(maxNum == 0){
            System.out.println("SAD");
        }else{
            System.out.println(maxNum);
            System.out.println(count);
        }

    }
}
