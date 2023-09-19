package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NandM3 {

    static int N, M;
    static int selected[];
    static StringBuilder sb = new StringBuilder();

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];

    }

    static void rec_func(int k) {
        if(k == M+1){ // 모두 다 선택 완료
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for(int cand = 1; cand <=N; cand ++){
                selected[k] = cand;
                // k+1 번 ~ M 번을 모두 탐색하는 일을 해야하는 상황.
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();

        rec_func(1);
        System.out.println(sb);
    }
}
