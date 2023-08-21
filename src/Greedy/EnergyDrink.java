package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EnergyDrink {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값 받기
        int N = sc.nextInt();
        Long arr[] = new Long[N];

        for(int i=0; i<N; i++){
            arr[i] = (long) sc.nextInt();
        }
        // 내림차순 정렬
       Arrays.sort(arr, new Comparator<Long>() {
           @Override
           public int compare(Long o1, Long o2) {
               return (int) (o2-o1);
           }
       });

        double sum = arr[0];
        // i = 1 ~ i = N-1 까지 반값 하면서 sum에 더하기
        for(int i=1; i<N; i++){

            sum = sum + (arr[i]/(double)(2));
        }

        System.out.println(check(sum));
    }
    public static String check(double d){
        if(d == (long) d) {
            return String.format("%d", (long) d);
        }
        else{
            return String.format("%s",d);
        }

    }

}
