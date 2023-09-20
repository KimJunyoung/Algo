package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartArray_ans {

    static int N, S, ans;
    static int arr[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N+1];
        ans = 0;

        for(int i=1; i<=N; i++) arr[i] = sc.nextInt();

    }

    static void rec_func(int k, int value){
        if(k == N+1){
            if(value == S) ans ++;
        }else {

            rec_func(k+1, value + arr[k]);

            rec_func(k+1, value);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1,0);

        if(S == 0) {
            ans --;
        }

        System.out.println(ans);
    }
}
