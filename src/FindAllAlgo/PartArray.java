package FindAllAlgo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartArray {

    static int N, S, ans, sum;
    static int arr[], selected[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N+1];
        selected = new int[N+1];
        ans = 0;

        for(int i=1; i<=N; i++) arr[i] = sc.nextInt();

    }

    static void rec_func(int k, int co){
        if(k == co + 1){
            sum = 0;
            for(int i=1; i<= co; i++){
                sum += selected[i];
            }
            System.out.println(sum + " " + ans);
            if(sum == S) ans ++;

        }else {
            // 1 ~ N 까지 부분 수열을 만들어야함.
            for(int c=1; c<=N; c++){
                if(selected[k-1] == arr[c]) continue;
                selected[k] = arr[c];
                rec_func(k+1, co);
                selected[k] = 0;
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        for(int i=1; i<=N; i++){
            rec_func(1,i);
        }
        System.out.println(ans);
    }
}
