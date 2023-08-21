package binarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeNumSum {

    public static boolean isExist(int arr[], int target){
        int start = 0;
        int last = arr.length - 1;

        while(start <= last){
            int middle = (start + last) / 2;
            if(arr[middle] > target){
                last = middle -1;
            }else if(arr[middle] < target){
                start = middle + 1;
            }else{
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int sequence = 0;
        // 입력 값 저장
        int N = sc.nextInt();
        int arr[] = new int[N];


        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // A+B를 저장하는 배열
        int arrSum[] = new int[(N * (N+1))/2];

        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                arrSum[sequence++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(arrSum);

        // X-C 값
        int ans = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int target = arr[i] - arr[j];
                if(isExist(arrSum, target)){
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        // 출력
        System.out.println(ans);
    }
}
