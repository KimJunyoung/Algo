package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddSomething {

    static int N, sum, ansMax, ansMin, start;
    static int arr[];
    static char selected[];
    static char charArr[];

    static StringBuilder sb = new StringBuilder();

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // 숫자 배열 입력
        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();

        // 연산자 입력
        int count = 0;
        charArr = new char[N];
        int A,B,C,D;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();

        for(int i=0; i<A; i++) charArr[count++] = '+';
        for(int i=0; i<B; i++) charArr[count++] = '-';
        for(int i=0; i<C; i++) charArr[count++] = 'x';
        for(int i=0; i<D; i++) charArr[count++] = '/';

        sum = 0;
        start = 0;
    }

    static void rec_func(int k) {
        if(k == N){
            for(int i=1; i<N; i++) {
                if(selected[i] == '+') {
                    sum = arr[i-1] + sum ;
                } else if(selected[i] == '-') {
                    sum = sum - arr[i-1];
                } else if(selected[i] == 'x') {
                    sum = sum * arr[i-1];
                } else {
                    sum = sum / arr[i-1];
                }
            }
            System.out.println(sum);
        } else {
            for(int i=start; i<N; i++){
                System.out.println(charArr[i]);
                rec_func(k+1);
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);

    }
}
