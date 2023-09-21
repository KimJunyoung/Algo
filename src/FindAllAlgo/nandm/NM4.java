package FindAllAlgo.nandm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NM4 {

    static int N, M, start;
    static int selected[];
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');

        }else {
            start = selected[k-1];
            if(start == 0) start = 1;
            for(int cond = start; cond <=N; cond++){
                selected[k] = cond;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }


    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M+1];
    }


    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(sb);
    }

}
