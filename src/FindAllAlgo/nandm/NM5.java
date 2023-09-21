package FindAllAlgo.nandm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NM5 {

    static int N,M;
    static int arr[], selected[], isUsed[];
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1;i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for(int cond =1; cond <= N; cond++){
                if(isUsed[cond] == 1) continue;
                selected[k] = arr[cond];
                isUsed[cond] = 1;
                rec_func(k+1);
                selected[k] = 0;
                isUsed[cond] =0;
            }
        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];
        selected = new int[M+1];
        isUsed = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(sb);
    }
}
