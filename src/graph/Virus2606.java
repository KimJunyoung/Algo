package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Virus2606 {

    static int N, M, count;
    static boolean visit[];
    static ArrayList<Integer> arrayList[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arrayList = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            arrayList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        visit = new boolean[N+1];

    }

    static void pro(){
        count = 0;
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int x){
        visit[x] = true;

        for (int y : arrayList[x]){
            if(visit[y]) continue;
            count ++;
            dfs(y);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
