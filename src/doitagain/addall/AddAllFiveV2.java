package doitagain.addall;

import java.io.*;
import java.util.Scanner;

public class AddAllFiveV2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫 줄
        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        int nArray [][] = new int[N+1][N+1];

        //

        for(int i=1; i<=N; i++){
            String[] anotherLine = br.readLine().split(" ");
            for(int j=1; j<= N; j++){
                nArray[i][j] = Integer.parseInt(anotherLine[j-1]);
            }
        }

        // 2차원 구간 합 배열 생성
        int sumArray[][] = new int[N+1][N+1];

        // 구간 합 더하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sumArray[i][j] = sumArray[i-1][j] + sumArray[i][j-1] - sumArray[i-1][j-1] + nArray[i][j];
            }
        }

        while(Q-- > 0){
            // 쿼리 문들
            String[] queryLines = br.readLine().split(" ");
            int x1 = Integer.parseInt(queryLines[0]);
            int y1 = Integer.parseInt(queryLines[1]);
            int x2 = Integer.parseInt(queryLines[2]);
            int y2 = Integer.parseInt(queryLines[3]);

            int sum = sumArray[x2][y2] - sumArray[x1-1][y2] - sumArray[x2][y1-1] + sumArray[x1-1][y1-1];

            bw.write(sum +"\n");
        }

        bw.flush();
    }
}
