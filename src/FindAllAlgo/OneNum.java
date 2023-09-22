package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OneNum {

    static int N, ans;

    static void bf_func(int k){
        // 탈출 시점
        if (k == N+1) {
            return;
        }

        if(k >= 1 && k <= 99) ans ++;
        else {
            int first = k / 100;
            int second = (k % 100) / 10;
            int third = k % 10;

            if((second - first) == (third - second)) ans ++;
        }

        bf_func(k+1);

    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        bf_func(1);
        System.out.println(ans);
    }

}
