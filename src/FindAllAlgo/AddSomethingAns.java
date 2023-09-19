package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddSomethingAns {

    static int N, max, min;
    static int arr[], operator[], orders[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        operator = new int[5];
        orders = new int[N+1];

        for(int i=1; i<= N; i++) arr[i] = sc.nextInt();
        for(int i=1; i<= 4; i++) operator[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

    }

    static int calc(){
        // orders 랑 operator로 계산해야함.
        int value = arr[1];

        for(int i=1; i<=N-1; i++){
            if(orders[i] == 1)  value = value + arr[i+1];
            if(orders[i] == 2)  value = value - arr[i+1];
            if(orders[i] == 3)  value = value * arr[i+1];
            if(orders[i] == 4)  value = value / arr[i+1];
        }
        return value;
    }

    static void rec_func(int k) {
        if(k == N){
            int value = calc();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else {
            for(int cand=1; cand<=4; cand++){
                if(operator[cand] >= 1){
                    operator[cand] --;
                    orders[k] = cand;
                    rec_func(k+1);
                    operator[cand] ++ ;
                    orders[k] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(max);
        System.out.println(min);

    }
}
