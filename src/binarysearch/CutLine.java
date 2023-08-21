package binarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CutLine {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값 받기
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 반복문 실행

        long l=0, r= (1L <<31) -1 , checkNum = -1;

        while(l<=r){
            long m = (l+r)/2;
            if(checkIt(arr, m, Q)){
                l= m+1;
                checkNum = m;
            }else{
                r = m-1;
            }
        }

        System.out.println(checkNum);

    }

    public static boolean checkIt(int arr[], long m, int q){
        long sum = 0L;
        for(int i=0; i<arr.length; i++){
            sum += arr[i] / m ;
        }

        return sum >= q;
    }
}
