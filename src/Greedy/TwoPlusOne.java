package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TwoPlusOne {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        Integer arr[] = new Integer[size];
        for(int i=0; i<size;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o2-o1;
            }
        });

        Long sum = 0L;
        for(int i=0; i<size;i++){
            if((i+1)%3 == 0) continue;
            sum += arr[i];
        }

        System.out.println(sum);



    }
}
