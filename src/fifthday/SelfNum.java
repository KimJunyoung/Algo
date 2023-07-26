package fifthday;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SelfNum {
    public static void main(String[] args) throws IOException {

        boolean num[] = new boolean[12000];

        for(int i=0; i<=10000; i++){
            if(i>=0&& i<10) {
                int first = i;
                int sum= i+first;
                num[sum] = true;
            }else if(i>=10 && i< 100){
                int first = i%10;
                int second = i/10;
                int sum = i + first + second;
                num[sum] = true;
            }else if(i >= 100 && i<1000){
                int third = i/100;
                int second = (i%100)/10;
                int first = (i%10);
                int sum = i + first + second + third;
                num[sum] = true;
            }else if(i >= 1000 && i<10000) {
                int fourth = i / 1000;
                int third = (i % 1000) / 100;
                int second = (i % 100) / 10;
                int first = (i % 10);
                int sum = i + first + second + third + fourth;
                num[sum] = true;
            }
        }

        for(int i=0; i<=10000; i++){
            if(!num[i]){
                System.out.println(i);
            }
        }
            }
}
