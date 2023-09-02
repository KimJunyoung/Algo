package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoneTry {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();

        char[] str = sc.next().toCharArray();

        int rightIndex = 0;
        int maxLength = 0;

        for(int i=0; i<N; i++){
            // B,W 카운트 할 변수 선언
            int countB = 0;
            int countW = 0;
            int countAns = 0;

            while(countB <= B && rightIndex <N){
                if(str[rightIndex++] == 'W'){
                    countW ++;
                }else {
                    countB ++;
                }
                countAns++;
            }

            System.out.print(countB + " " + countW + " rightIndex " + rightIndex);
            System.out.println();

            if(countB > B){
                i = rightIndex - 1;
            }

            if(countB <= B && countW >= W){
                maxLength = Math.max(maxLength,countAns);
                System.out.println(maxLength);
            }
        }
        System.out.println(maxLength);
    }
}
