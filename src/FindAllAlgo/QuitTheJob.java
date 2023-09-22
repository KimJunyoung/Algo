package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuitTheJob {

    static int N, ans, min;
    static int arr[][];


    static void rec_func(int k) {
        if(k >= N || k + arr[k][0] > N + 1) {
            if(arr[N][0] == 1){
                min += arr[N][1];
            }

            ans = Math.max(ans, min);

        } else{

            min += arr[k][1];

            System.out.println("index " + k + " " + min);

            rec_func(k+ arr[k][0]);

            System.out.println("==== start ====");

            min -= arr[k][1];

            System.out.println("index " + k + " " + min);

            rec_func(k+1);

        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = Integer.MIN_VALUE;
        arr = new int[N+1][2];

        for(int i=1; i<=N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}
