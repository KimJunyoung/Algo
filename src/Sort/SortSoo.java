package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SortSoo {

    static int N;
    static int[] P;
    static WantToSort[] B;

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        B = new WantToSort[N];
        P = new int[N];

        for(int i=0; i<N; i++){
            B[i] = new WantToSort();
            B[i].num = scanner.nextInt();
            B[i].idx = i;
        }
    }

    static void pro(){
        Arrays.sort(B);
        for(int i=0 ;i<N; i++){
            P[B[i].idx] = i;
        }
        for(int i=0; i<N; i++){
            System.out.print(P[i] + " ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }

}


class WantToSort implements Comparable<WantToSort>{

    int num, idx;

    @Override
    public int compareTo(WantToSort o) {
        if(!(this.num == o.num)) return num - o.num;
        return idx - o.idx;
    }
}
