package Sort;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 배열 저장하는 방법 arr[101][101] O
 * 각 행, 열의 갯수를 세어서 정렬하는 방법 -> 행 / 열 ArrayList 를 이용하는 건 어떨 까 ?
 * 정렬한 부분을 배열에 추가
 * 배열의 크기가 100이 넘었을 시 나중에 것을 버리는 것
 */

public class TwoArrayAnd {

    static int R,C,K,ans;
    static int[][] arr;
    static int[] countArr;
    static boolean check;

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        check = true;
        ans = 0;

        countArr = new int[101];
        arr = new int[101][101];

        for(int i=1; i<=3; i++){
            for(int j=1; j<=3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static public void func(){
        int row = 3;
        int col = 3;

        while(true){
            if(arr[R][C] == K) break;

            int count = 1;
            int countRow = 1;

            if(row > col){
                // 열 정렬
                for(int i=1; i<=col; i++){
                    // 초기화
                    countArr = new int[101];
                    countRow = 1;

                    for(int j=1; j<=row; j++){
                        int value = arr[j][i];
                        countArr[value] += 1;
                    }

                    for(int k=1; k<=100; k++){
                        if(countArr[k] == 0) continue;
                        arr[countRow++][i] = k;
                        arr[countRow++][i] = countArr[k];
                    }
                    for(int l=countRow; l<=100; l++){
                        arr[l][i] = 0;
                    }

                    countRow--;
                    row = Math.max(row, countRow);
                }

            }else {
                // 행 정렬
                for(int i=1; i<= row; i++){
                    // 초기화
                    countArr = new int[101];
                    count =1;

                    for(int j=1; j<=col; j++){
                        int value = arr[i][j];
                        countArr[value] += 1;
                    }

                    for(int k=1; k<=100; k++){
                        if(countArr[k] == 0 ) continue;
                        arr[i][count++] = k;
                        arr[i][count++] = countArr[k];
                    }
                    for(int l=count; l<=100; l++){
                        arr[i][l] = 0;
                    }
                    count --;
                    col = Math.max(col, count);
                }

            }

            for(int i=1; i<=100; i++){
                for(int j=1; j<=100; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();

            ans ++;

            if(ans >= 100) {
                check = false;
                break;
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        func();
        if(check) {
            System.out.println(ans);
        }else {
            System.out.println(-1);
        }

    }
}
