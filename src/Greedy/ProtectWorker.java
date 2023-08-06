package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProtectWorker {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        Integer arr[] = new Integer[arrSize];
        int count = 1;
        Long sum = 0L;

        for(int i=0; i<arrSize; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        for(int i=0; i<arrSize; i++){
            if(arr[i] - (count-1) < 0)
                break;
            sum += (arr[i] - (count-1));
            count++;
        }
        System.out.println(sum);


    }
}
