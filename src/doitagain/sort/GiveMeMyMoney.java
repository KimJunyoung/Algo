package doitagain.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiveMeMyMoney {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        int N = sc.nextInt();

        // 저장할 변수
        int count = 0;

        // 반복문 돌기
        while(N > 0){
        // 5원 체크
        if(N % 5 == 0){
            count += N / 5;
            System.out.println(count);
            break;
        }
        if(N == 1){
            System.out.println(-1);
            break;
        }
        // 2원 체크
            count += 1;
            N = N - 2;
        }

    }
}
