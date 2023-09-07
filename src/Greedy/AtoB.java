package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AtoB {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        // 2로 나눠지면 나누기 / 아니면 맨 뒷자리 1 빼기
        int count = 0;

        while(true){

            if(B % 2 == 0){
                B = B / 2 ;
                count ++;
            }else{
               if(B % 10 != 1){
                   count = -2;
                   break;
               } else{
                   B = B / 10;
                   count ++;
               }
            }

            if(B < A){
                count = -2;
                break;
            }

            if(A == B){
                break;
            }
        }

        System.out.println(count + 1);
    }


}
