package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Card {
    static int N;
    static Long[] arrInput;

    public static void pro(){
        Arrays.sort(arrInput);
//        for(int i=0; i<N; i++){
//            System.out.print(arrInput[i]+ " ");
//    }
        int count = 0;
        Long check = arrInput[0];
        Long ans = arrInput[0];
        int countAns = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            if(check.equals(arrInput[i])) count++;
            else {
                check = arrInput[i];
                count = 1;
            }
            if(count > countAns){
                countAns = count;
                ans = check;
            }
        }

        System.out.println(ans);
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arrInput = new Long[N];
        for(int i=0; i<N; i++){
            arrInput[i] = sc.nextLong();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
