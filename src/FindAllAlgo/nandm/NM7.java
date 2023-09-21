package FindAllAlgo.nandm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NM7 {

    static int N,M, start;
    static int arr[], selected[];
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else {
            for(int cond =1; cond<=N; cond++){
                    selected[k] = arr[cond];
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

        arr = new int[N+1];
        selected = new int[M+1];

        for(int i=1; i<=N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(sb);

    }
}
