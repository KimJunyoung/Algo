package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int count = P;
        int max = 0;
        int arr[] = new int[P];
        for(int i=0; i<P; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<P; i++){
            max = Math.max(max, (arr[i] * count--));
        }

        System.out.println(max);


    }
}
