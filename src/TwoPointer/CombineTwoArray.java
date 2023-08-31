package TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CombineTwoArray {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값
        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        String[] thirdLine = br.readLine().split(" ");

        int A = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);

        int [] ans = new int[A+B];

        for(int i=0; i<secondLine.length;i++){
            ans[i] = Integer.parseInt(secondLine[i]);
        }

        for(int i=A; i<ans.length;i++){
            ans[i] = Integer.parseInt(thirdLine[i-A]);
        }

        Arrays.sort(ans);

        for (int an : ans) {
           bw.write(an + " ");
        }

        bw.flush();
    }
}
