package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class arrayPra {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[][] = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }





    }
}
