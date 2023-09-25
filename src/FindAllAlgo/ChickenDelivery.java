package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChickenDelivery {

    // 치킨집이 있을 때 M개를 고르는 모든 조합의 배열을 만들기 ( 이걸 백트래킹으로 하자)
    // 만들어진 각 배열을 통해 각 집에서 치킨집 까지 거리 구하기
    // -> 2차월 배열을 다 돌면서 2가 나오면 1의 좌표가 저장된 값의 차를 구한다.
    // 모든 집의 치킨집 까지의 거리를 더하기
    // 다 더해진 값 중에 최솟 값을 구하자.

    static int N, M, ans;
    static int[][] inputArr,  isUsed, selected;

    public static int[][] makeTwoArr(int [][] select){
        int [][] newMake = new int[N+1][N+1];

        for(int i=1; i<= N; i++){
            for(int j=1; j<=N; j++) {
                newMake[i][j] = inputArr[i][j];
            }
        }

        for(int i=1; i<= N; i ++){
            for(int j=1; j<= N; j++){
                if(newMake[i][j] == 2){
                    boolean check = false;
                    for(int c = 1; c<= M ; c++){
                        if(select[c][0] == i && select[c][1] == j){
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        newMake[i][j] = 0;
                    }
                }
            }
        }
        return newMake;
    }

    public static int sumChickenDistance(int[][] arr){

        int sum = 0;

        for(int i = 1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j] == 1) {
                    int returnDistance = Integer.MAX_VALUE;

                    for(int k=1; k<= N; k++){
                        for(int l=1; l<=N; l++){
                            if(arr[k][l] == 2 ) {
                                int checkDistance = Math.abs(i - k) + Math.abs(j - l);
                                 returnDistance = Math.min(checkDistance, returnDistance);
                            }
                        }
                    }
                    sum += returnDistance;
                }
            }
        }

    return sum;

    }

    public static void rec_func(int k){
        if(k == M+1){
            int[][] made = makeTwoArr(selected);
            int chickenDistance = sumChickenDistance(made);
            ans = Math.min(chickenDistance, ans);

//            for(int i=1; i<=N; i++){
//                for(int j=1; j<=N; j++){
//                    System.out.print(made[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println(" ------- ");

        }else {
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(inputArr[i][j] == 2) {
                        if(isUsed[i][j] == 1) continue;
                        if(selected[k-1][0] > i) continue;
                        selected[k][0]= i;
                        selected[k][1]= j;
                        isUsed[i][j] = 1;

                        rec_func(k+1);

                        selected[k][0] = 0;
                        selected[k][1] = 0;
                        isUsed[i][j] = 0;

                    }
                }
            }

        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int count = 1;

        N = sc.nextInt();
        M = sc.nextInt();
        ans = Integer.MAX_VALUE;

        inputArr = new int[N+1][N+1];
        isUsed = new int[N+1][N+1];
        selected = new int[14][2];
        for(int i=1; i<= N; i++){
            for(int j=1; j<=N; j++){
                inputArr[i][j] = sc.nextInt();
//                if(inputArr[i][j] == 1){
//                    numOneArr[count][1] = i;
//                    numOneArr[count][2] = j;
//                    count ++;
//                }
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}
