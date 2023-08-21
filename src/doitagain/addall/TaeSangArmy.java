package doitagain.addall;

import java.io.*;
import java.util.Scanner;

public class TaeSangArmy {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int arr[] = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(secondLine[i-1]);
        }

        int arrIndex[] = new int[N+2];

        while(Q-- > 0){
            String[] thirdLine = br.readLine().split(" ");
            int firstInput = Integer.parseInt(thirdLine[0]);
            int secondInput = Integer.parseInt(thirdLine[1]);
            int thirdInput = Integer.parseInt(thirdLine[2]);

            arrIndex[firstInput] += thirdInput;
            arrIndex[secondInput+1] -= thirdInput;
        }

        int arrSum[] = new int[N+1];
        for(int i=1; i<=N; i++){
            arrSum[i] = arrIndex[i] + arrSum[i-1];
        }

        // 더하기
        for(int i=1; i<=N; i++){
            bw.write(arr[i] + arrSum[i] + " ");
        }
        bw.flush();

    }
}
