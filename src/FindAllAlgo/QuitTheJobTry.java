package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuitTheJobTry {

    static int N, ans, min;
    static int arr[][];


    static void rec_func(int k, int value) {
        if(k >= N ){
           ans = Math.max(ans, value);
        } else{

            // 조건 추가
           if(k + arr[k][0] <= N + 1) rec_func(k + arr[k][0] , value + arr[k][1]);


            rec_func( k+1 , value);

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
        rec_func(1,0);
        System.out.println(ans);
    }

}
