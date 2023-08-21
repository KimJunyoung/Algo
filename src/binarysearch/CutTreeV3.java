package binarysearch;

import java.io.*;
import java.util.Arrays;

public class CutTreeV3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값
        String[] firstInput = br.readLine().split(" ");
        String[] secondInput = br.readLine().split(" ");

        int N = Integer.parseInt(firstInput[0]);
        Long T = Long.parseLong(firstInput[1]);

        Long treeH[] = new Long[N];
        for (int i = 0; i < N; i++) {
            treeH[i] = Long.parseLong(secondInput[i]);
        }

        // 정렬
        Arrays.sort(treeH);

        Long right = isRight(treeH, T);
        bw.write(right +"");
        bw.flush();

    }

    static Long isRight(Long[] arr, Long T) {

        long l = 0, r = 1000000000, target = -1;

        while (l <= r) {
            long m = (l + r) / 2;
            if (targetNum(arr,m,T)) {
                target = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return target;
    }


    static Boolean targetNum(Long[] arr, Long m, Long t){
        long sum= 0;
        for (Long aLong : arr) {
            if(aLong > m) sum += aLong - m;
        }
        return sum >= t;
    }





}

