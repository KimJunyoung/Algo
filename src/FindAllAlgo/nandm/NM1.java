package FindAllAlgo.nandm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NM1 {

    static int N, M;
    static int selected[], isUsed[];

    static void rec_func(int k){
        // backtracking 의 종료시점
        if(k == M+1){
            for(int i=1; i<=M; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
        }else {
            for(int cond = 1; cond <= N; cond ++){
                if(isUsed[cond] == 1) continue;

                selected[k] = cond;
                isUsed[cond] = 1;

                rec_func(k+1);

                selected[k] = 0;
                isUsed[cond] = 0;
            }
        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M+1];
        isUsed = new int[N + 1];
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
    }
}
