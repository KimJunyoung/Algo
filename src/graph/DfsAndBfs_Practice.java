package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class DfsAndBfs_Practice {

    static int N, M, V;
    static ArrayList<Integer> arrayList[];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();


    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arrayList = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            arrayList[i] = new ArrayList<Integer>();
        }

       // 입력
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(arrayList[i]);
        }

    }

    public static void pro(){
        check = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        for(int i=1; i<=N; i++){
            check[i] = false;
        }
        bfs(V);


    }

    public static void dfs(int x){
        check[x] = true;
        sb.append(x).append(" ");

        for(int y : arrayList[x]){
            if(check[y]) continue;

            dfs(y);
        }
    }

    public static void bfs(int x){

        Queue<Integer> que = new LinkedList<>();
        check[x] = true;
        que.add(x);

        while(!que.isEmpty()){
            Integer a = que.poll();
            sb.append(a).append(" ");

            for(int y : arrayList[a]){
                if(check[y]) continue;
                que.add(y);
                check[y] = true;
            }

            for (Integer integer : que) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
