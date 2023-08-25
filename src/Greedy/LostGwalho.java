package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LostGwalho {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        String[] split = sc.next().split("-");
        int sum = 0;

        for (int i=0; i<split.length; i++) {
            int sumEach = 0;
            String[] s1 = split[i].split("\\+");

            for(int j=0; j<s1.length; j++){
                sumEach += Integer.parseInt(s1[j]);
            }

            if(i==0){
                sum += sumEach;
            }else{
                sum -= sumEach;
            }
        }

        System.out.println(sum);



    }
}
