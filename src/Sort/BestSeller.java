package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BestSeller {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String arr[] = new String[size];

        for(int i=0; i<size; i++){
            arr[i] = sc.next();
        }

        String MaxBook = arr[0];
        int count = 1;
        int countMax = 1;

        Arrays.sort(arr);

        for(int i=1; i<size;i++){
            if(!arr[i].equals(arr[i-1])){
                count = 0;
            }
            count ++ ;
            if(count > countMax || countMax == count && arr[i].compareTo(MaxBook) < 0){
                countMax = count;
                MaxBook = arr[i];
            }
        }

        System.out.println(MaxBook);


    }
}
