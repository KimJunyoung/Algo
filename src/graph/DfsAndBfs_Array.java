package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsAndBfs_Array {

    // 간선 및 정점, 시작 위치 저장
    public static int N;
    public static int M;
    public static int V;

    public static int arr[][];
    public static boolean check[];

    static StringBuilder sb = new StringBuilder();

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new int[N+1][N+1];

        // 그래프 -> 배열으로 저장
        for(int i=1; i<=M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
    }

    public static void pro() throws FileNotFoundException {
         check = new boolean[N+1];
         dfs(V);
         sb.append('\n');
         for(int i=1; i<=N; i++) check[i] =false;
         bfs(V);
    }

    public static void dfs(int x){
        check[x] = true;
        sb.append(x).append(" ");

        for(int y=1; y<=N; y++){
            if(check[y]) continue;
            if(arr[x][y] == 0) continue;

            dfs(y);
        }
    }

    public static void bfs(int a){
        Queue<Integer> que = new LinkedList<>();
        que.add(a);
        check[a] = true;

        while(!que.isEmpty()){
            Integer x = que.poll();
            sb.append(x).append(" ");

            for(int y=1; y<=N; y++){
                if(check[y]) continue;
                if(arr[x][y] == 0) continue;

                check[y] = true;
                que.add(y);
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
        System.out.println(sb);
    }
}
