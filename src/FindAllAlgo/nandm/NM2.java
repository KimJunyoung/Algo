package FindAllAlgo.nandm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NM2 {

    static int N, M;
    static int selected[];
    static StringBuilder sb = new StringBuilder();


    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for(int cond = selected[k-1] + 1; cond<=N; cond++){
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
