package binarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Double {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        Long number = sc.nextLong();

        // 범위값
        System.out.println(Math.abs(calc(number)));


    }

    static long calc(long x){
        if(x == 0){
            return 0;
        }

        long l = 1 , r = 1L << 32, sqrt = -1;
        while(l <= r){
            long m = (l + r) / 2;
            long doubleNum = (long) Math.pow(m,2);
            if(doubleNum < x){
                l = m + 1;
            }else {
                r = m-1;
                sqrt = m;
            }
        }
        return sqrt;
    }

}
