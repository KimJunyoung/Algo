package doitagain.halfsearching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값 받기
        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }


        // A+B 의 배열 만들기
        int aPlusB[] = new int[(N * (N+1))/2];
        int sequence = 0;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                aPlusB[sequence++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(aPlusB);

        int ans = -1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int target = arr[i] - arr[j];
                if(isExist(aPlusB, target)){
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        System.out.println(ans);

    }

    static boolean isExist(int arr[], int target){
        int l = 0, r = arr.length -1;
        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] > target){
                r = m-1;
            }else if(arr[m] < target){
                l = m +1;
            }else {
                return true;
            }
        }
        return false;
    }
}
