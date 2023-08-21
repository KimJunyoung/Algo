package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Water {

    public static  int pairValueCheck(int arr[], int fromIndex, int toIndex, int target){
        int absCheck = 2000000000;
        int pairValue = 0;

        int l = fromIndex;
        int r = toIndex;

        while(l<=r){
            int middle = (l+r) / 2;
            int sum = target + arr[middle];
            int abs = Math.abs(sum);
            if(abs < absCheck){
                absCheck = abs;
                pairValue = arr[middle];
            }
            if(sum < 0){
                l  = middle + 1;
            }else if(sum > 0){
                r = middle - 1;
            }else{
                return arr[middle];
            }
        }
        return pairValue;

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값
        int N = Integer.parseInt(br.readLine());
        String arrString[] = new String[N];
        arrString = br.readLine().split(" ");
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(arrString[i]);
        }

        Arrays.sort(arr);

        // 전체적인 구상
        // 최대값이 될 수 있는 abs 값을 int 변수에 저장
        int absCheck = 2000000000;
        // 출력을 위해 두가지 변수가 필요하다.
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<N-1; i++){
            int pairValue = pairValueCheck(arr, i+1, N-1, arr[i]);
            int absSum = Math.abs(pairValue + arr[i]);
            if(absSum < absCheck){
                absCheck = absSum;
                num1 = arr[i];
                num2 = pairValue;
            }
        }

        // 출력
        bw.write(num1 + " " + num2);

        bw.flush();
    }
}
