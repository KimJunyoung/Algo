package sevenday;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class CheckNum {

    public static int[] changingArray(int x, int i){
        int copy = x;
        int count = 0;

        while(copy > 0) {
            copy = copy / i;
            count ++;
        }
        int array[] = new int[count];
        int len = 0;

        while(x > 0){
            array[len++] = x % i;
            x = x / i;
        }

        return array;
    }

    public static boolean checkingArray(int arr[]){

        int len = arr.length;

        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[len - i -1]){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        while(P-- > 0){
            int x = sc.nextInt();
            boolean check = false;

            for(int i=2; i<=64; i++){

                int changedArray[] = changingArray(x, i);

                if(checkingArray(changedArray)){
                    check = true;
                    break;
                }

            }

            System.out.println(check ? 1 : 0);
        }


       /*
        char alpArray[] = new char[74];
        char aAlpha = 'A';
        char aAlpha2 = 'a';
        char aAlpha3 = '0';

        for(int i=0; i<75; i++){
            if(i>=0 && i<=25){
                alpArray[i+10] = aAlpha;
                aAlpha++;
            }
            if(i>25 && i<= 51){
                alpArray[i+10] = aAlpha2;
                aAlpha2++;
            }
            if(i>51 && i<=61){
                alpArray[i+10] = aAlpha3;
                aAlpha3++;
            }
            if(i == 62){
                alpArray[i+10] = '+';
            }
            if(i == 63){
                alpArray[i+10] = '/';
            }

        }


        int P = sc.nextInt();
        boolean check = false;

        while(P-- > 0){
            int nums = sc.nextInt();
            check = false;

            // 2~ 64
            for(int i=2; i<= 64; i++){

                String string = "";
                String stringRev ="";
                int size = nums;
                int count = 0;


                while(size > 0){
                    size = size / i;
                    count ++;
                }

                size = nums;

                for(int j=0; j<count; j++){
                    if(size % i >= 10){
                    string = alpArray[( size % i )] + string;
                    } else
                    string = ( size % i ) + string;
                    size = size / i;
                }

                for(int k=0; k<string.length(); k++){
                    stringRev = string.charAt(k) + stringRev;
                }

               if(string.equals(stringRev)){
                   check = true;
                   System.out.println(1);
                   break;
               }


            }
            if(!check){
                System.out.println(0);
            }


        }*/




    }
}
