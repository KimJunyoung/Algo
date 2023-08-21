package doitagain.addall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddAllFive {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int nArray [][] = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                nArray[i][j] = sc.nextInt();
            }
        }

        int[][] accRow = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                accRow[i][j] = accRow[i][j-1] + nArray[i][j];
            }
        }

        while(Q-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int sum = 0;

            for(int x = x1; x<= x2; x++){
                sum += accRow[x][y2] - accRow[x][y1-1];
            }

            System.out.println(sum);
        }
    }
}
