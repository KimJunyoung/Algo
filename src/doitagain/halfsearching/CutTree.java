package doitagain.halfsearching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CutTree {
    // 잘라서 가져갈 수 있는 나무의 총 합을 게산하는 메서드
    public static boolean isValid(long arr[], long m, long M){
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= m){
                sum += arr[i] - m ;
            }
        }

        return sum >= M;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        long M = sc.nextLong();
        long arr[] = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextLong();
        }

        // 총 합이랑 M 이랑 비교하면서 이분탐색을 할 알고리즘 필요.
        long l = 0L, r = 1000000000 , checkNum = 0L;

        while(l<=r){
            long m = (l+r)/2;
            if(isValid(arr,m,M)){
                l = m+1;
                checkNum = m;
            }else {
                r = m-1;
            }
        }

        System.out.println(checkNum);
    }
}
