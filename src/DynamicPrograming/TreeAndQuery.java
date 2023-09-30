package DynamicPrograming;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TreeAndQuery {

    static int N,R,Q;
    static int[] visited, dp, want;
    static ArrayList<Integer>[] arrayLists;

    public static void dfs(int x){
            dp[x] = 1;
            visited[x] = 1;
            for(int y : arrayLists[x]){
                if(visited[y] == 1) continue;
                dfs(y);
                dp[x] += dp[y];
            }
    }

    public static void pro(){
        dp = new int[N+1];
        dfs(R);

        for(int i=1; i<=Q; i++){
            int q = want[i];
            System.out.println(dp[q]);
        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        visited = new int[N+1];
        arrayLists = new ArrayList[N+1];
        want = new int[Q+1];

        for(int i=1; i<=N; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        for(int i=1; i<=Q; i++){
            want[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
