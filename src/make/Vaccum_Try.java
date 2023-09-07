package make;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vaccum_Try {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[N][M];
        int arrIndex[] = new int[2];

        arrIndex[0] = sc.nextInt();
        arrIndex[1] = sc.nextInt();

        int whereTo = sc.nextInt(); // 0 , 1 , 2 , 3

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 횟수 체크
        int count = 0;


        System.out.println("------------------------------");

        while(true){
            if (arr[arrIndex[0]][arrIndex[1]] == 0){
                arr[arrIndex[0]][arrIndex[1]] = 1;
                count ++;
            }

            if(areaCheck(arr,arrIndex)){
                //방향
                if(whereTo == 0){
                    whereTo = 3;
                    if(whereToCheck(arr, whereTo, arrIndex)){
                        arr[arrIndex[0]][arrIndex[1]] = 1;
                        count ++ ;
                    }
                }else {
                    whereTo --;
                    if(whereToCheck(arr, whereTo, arrIndex)){
                        arr[arrIndex[0]][arrIndex[1]] = 1;
                        count ++;
                    }
                }
            } else {
                if(arrIndex[1] - 1 == 0){
                    break;
                } else {
                    arrIndex[1]--;
                }
            }

            for (int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("------------------------------");

        }

        System.out.println(count);
    }

    static boolean whereToCheck(int[][] arr, int whereTo,int[] arrIndex){
        int X = arrIndex[0];
        int Y = arrIndex[1];

        if(whereTo == 0){
            if(arr[X-1][Y] == 0){
                arrIndex[0] = X-1;
                return true;
            }else {
                return false;
            }
        }else if(whereTo == 1){
            if(arr[X][Y+1] == 0){
                arrIndex[1] = Y+1;
                return true;
            }else {
                return false;
            }
        }else if(whereTo == 2){
            if(arr[X+1][Y] == 0){
                arrIndex[0] = X+1;
                return true;
            }else {
                return false;
            }
        }else{
            if(arr[X][Y-1] == 0){
                arrIndex[1] = Y-1;
                return true;
            }else {
                return false;
            }
        }

    }

    static boolean areaCheck(int[][] arr, int[] arrIndex){
        int X = arrIndex[0];
        int Y = arrIndex[1];

        if(arr[X-1][Y] == 1 && arr[X+1][Y] == 1 && arr[X][Y+1] == 1 && arr[X][Y-1] == 1){
            return false;
        }
        return true;
    }


}
