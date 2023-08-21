package doitagain.addall;

import java.io.*;
import java.util.Scanner;

public class GenericQueries {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int arr[] = new int[N+1];

        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(secondLine[i-1]);
        }
        int xorArr[] = new int[N+1];
        // XOR 총 구간 ..
        for(int i=1; i<=N; i++){
            xorArr[i] = arr[i] ^ xorArr[i-1];
        }
        int ans = 0;

        while(Q-- > 0){
            String[] thirdLine = br.readLine().split(" ");
            int firstIndex = Integer.parseInt(thirdLine[0]);
            int lastIndex = Integer.parseInt(thirdLine[1]);

            int xor ;
            xor = xorArr[firstIndex-1] ^ xorArr[lastIndex];
            ans = xor ^ ans;
        }

        bw.write(ans + "");
        bw.flush();
    }
}
