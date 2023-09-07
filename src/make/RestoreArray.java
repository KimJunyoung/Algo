package make;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestoreArray {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int H = sc.nextInt();
        int W = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int arr[][] = new int[H+X][W+Y];
        int ans[][] = new int[H][W];

        for(int i=0; i<H+X; i++){
            for(int j=0; j<W+Y; j++){
                arr[i][j]  = sc.nextInt();
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(i >= X && j >= Y){
                    ans[i][j] = arr[i][j] - ans[i-X][j-Y];
                } else if(i < X || j < Y){
                    ans[i][j] = arr[i][j];
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }






    }
}
