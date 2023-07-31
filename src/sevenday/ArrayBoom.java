package sevenday;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayBoom {

    public static void swapArray(char arr[][],int i,int j, int k, int l){
       char tmp = arr[i][j];
        arr[i][j] = arr[k][l];
        arr[k][l] = tmp;
    }

    public static int findMaxRow(char[][] arr){
        int N = arr.length;
        int max = 0;

        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=1; j<N; j++){
                if(arr[i][j] == arr[i][j-1]){
                    count ++;
                }else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public static int findMaxCol(char[][] arr){
        int N = arr.length;
        int max = 0;
        for(int i=0; i<N; i++){
            int count = 1;
            for(int j=1; j<N; j++){

                if(arr[j][i] == arr[j-1][i]){
                    count ++;
                }else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        char checkArray1[][] = new char[P][P];

        for (int i = 0; i < P; i++) {
            checkArray1[i] = sc.next().toCharArray();
        }

        int max1 =0;

        for(int i=0; i<P; i++){
            for(int j=0; j<P; j++){
                if(j+1 < P && checkArray1[i][j] != checkArray1[i][j+1]){
                    swapArray(checkArray1, i, j, i, j+1);
                    max1 = Math.max(max1, Math.max(findMaxRow(checkArray1), findMaxCol(checkArray1)));
                    swapArray(checkArray1, i, j, i, j+1);
                }
                if(i+1 < P && checkArray1[i][j] != checkArray1[i+1][j]){
                    swapArray(checkArray1, i, j, i+1, j);
                    max1 = Math.max(max1, Math.max(findMaxRow(checkArray1), findMaxCol(checkArray1)));
                    swapArray(checkArray1, i, j, i+1, j);
                }
            }
        }

        System.out.println(max1);
    }


}
