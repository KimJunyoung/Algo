package binarysearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CutTreeV2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값

        int N = sc.nextInt();
        int T = sc.nextInt();

        int treeH[] = new int[N];
        for (int i = 0; i < N; i++) {
            treeH[i] = sc.nextInt();
        }

        int right = isRight(treeH, T);
        System.out.println(right);

    }

    static int isRight(int[] arr, int T) {

        int l = 0, r = 1000000000, target = -1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (targetNum(arr,m,T)) {
                target = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return target;
    }


    static boolean targetNum(int[] arr, int m, int thr){
        long sum= 0;
        for (Integer aLong : arr) {
            if(aLong > m) sum += aLong - m;
        }
        return sum >= thr;
    }





}

