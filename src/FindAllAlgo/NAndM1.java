package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NAndM1 {

    static int N, M;
    static int isUsed[], selected[];
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        // 재귀함수를 돌면서 selected 배열에 값들을 계속 저장한다.
        // 이게 적절한 갯수에 해당되면 출력한다.
        // 그러면 재귀 함수가 종료되고 재귀 함수 전으로 돌아간다
        // 그래서 반복문을 돌면서 K+1 을 증가시킨 재귀함수를 실행시킨다.
        // 계속 반복한다.
        if(k == M+1){
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for(int cand=1; cand<=N; cand++){
                if(isUsed[cand] == 1) continue;
                selected[k] = cand;
                isUsed[cand] = 1;

                // 결국 증가시키는 건 무엇이냐 ?
                // visited 배열에 들어갈 k 값을 증가 시키는 것이다.
                // k값이 index 라고 가정하면 value 값은 무엇으로 증가시키나 ?
                // 반복문을 통해서 값을 증가시킨다.
                // k 값이 일정조건에 맞게 최대치로 증가 됐을 땐 출력을 한다.
                // 그러고 나면 그 해당 재귀함수는 종료된다.
                // 그러면 반복문을 통해서 해당 k 값의 value를 증가시킨다.
                rec_func(k+1);


                selected[k] = 0;
                isUsed[cand] = 0;
            }
        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M+1];
        isUsed = new int[N+1];
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
