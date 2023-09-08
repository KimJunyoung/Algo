package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class DfsAndBfs_ArrayList {


    // 간선 및 정점, 시작 위치 저장
    public static int N;
    public static int M;
    public static int V;

    public static ArrayList<Integer>[] arrayLists ;
    public static boolean check[];

    static StringBuilder sb = new StringBuilder();

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arrayLists = new ArrayList[N+1];

        // 그래프 저장 -> ArrayList
        for(int i=1; i<=N; i++){
            arrayLists[i] = new ArrayList<>();
        }

        // 그래프 -> 배열으로 저장
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arrayLists[i]);
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

        for(int y : arrayLists[x]){
            if(check[y]) continue;
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

            for(int y : arrayLists[x]){
                if(check[y]) continue;
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
