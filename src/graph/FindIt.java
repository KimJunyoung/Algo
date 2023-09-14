package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindIt {

    static int X , Y ;
    static boolean visited[];
    static int dist[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        Y = sc.nextInt();
        visited = new boolean[100005];
        dist = new int[100005];
    }

    static void pro(){
        bfs(X);
        System.out.println(dist[Y]);
    }

    static void bfs(int x){

        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        dist[x] = 0;
        visited[x] = true;

        while(!que.isEmpty()){
            int a = que.poll();

            if(a -1 >= 0 && !visited[a - 1]){
                visited[a-1] = true;
                dist[a -1] = dist[a] + 1;
                que.add(a - 1);
            }
            if(a + 1 <= 100000 && !visited[a + 1]){
                visited[a+1] = true;
                dist[a+1] = dist[a] + 1;
                que.add(a + 1);
            }
            if(a * 2 <= 100000 && !visited[a * 2]){
                visited[a*2] = true;
                dist[a*2] = dist[a] + 1;
                que.add(a * 2);
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
