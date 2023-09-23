package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartAndLink {

    static int N,M,ans, sum1,sum2;
    static int selected[], notSelected[], inputArr[][] , isUsed[];


    static int findArraySum(int select[], int noSelect[]){

        sum1 = 0;
        sum2 = 0;

        // 반복문 수행
        for(int i=1; i<=M; i++){
            for(int j=i; j<=M; j++){
                int a = select[i];
                int b= select[j];
                int c = noSelect[i];
                int d = noSelect[j];

                sum1 = sum1 + inputArr[a][b] + inputArr[b][a];
                sum2 = sum2 + inputArr[c][d] + inputArr[d][c];

            }
        }

        return Math.abs(sum1-sum2);
    }


    static void rec_func(int k){
        if(k == (M +1)){
            // 선택되지 않은 값들 배열에 저장
            int index = 1;
            int ansIndex = 1;

            for(int i=1; i<=N; i++){
                if(isUsed[i] == 0){
                    notSelected[index++] = i;
                }
            }

            int arraySum = findArraySum(selected, notSelected);
            ans = Math.min(ans, arraySum);

        } else {

            for(int cond = selected[k-1] + 1; cond <= N; cond ++){

                selected[k] = cond;
                isUsed[cond] = 1;

                rec_func(k+1);

                selected[k] = 0 ;
                isUsed[cond] = 0;

            }

        }
    }

    static void input() throws FileNotFoundException {
        // 입력값 받기
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = N / 2;
        selected = new int[M+1];
        notSelected = new int[M+1];
        isUsed = new int[N+1];
        inputArr = new int[N+1][N+1];
        ans = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                inputArr[i][j] = sc.nextInt();
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}
