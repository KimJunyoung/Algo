package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Atm {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int arr[] = new int[P];

        for(int i=0; i<P; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int sum = 0;
        int count = P;

        for(int i=0;i<P;i++){
            sum += arr[i] * count;
            count--;
        }

        System.out.println(sum);

    }
}
