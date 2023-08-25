package doitagain.halfsearching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Double {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        long thisNum = sc.nextLong();

        System.out.println(Math.abs(checkValue(thisNum)));
    }

    public static Long checkValue(long target){

        if(target == 0){
            return 0L;
        }

        // 범위 값 지정
        long l = 1, r = 1L << 32, check = -1;

        while (l<=r){
            long m = (l+r)/2;
            if(m >= (target-1)/m +1){
                r = m-1;
                check = m;
            }else {
             l = m+1;
            }

        }
        return  check;
    }
}
