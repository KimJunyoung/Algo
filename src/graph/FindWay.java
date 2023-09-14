package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindWay {

    static int N;
    static int arr[][];
    static boolean visited[];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void dfs(int x){

        for(int y=1; y<=N; y++){
            if(arr[x][y] == 0) continue;
            if(visited[y]) continue;

            visited[y] = true;
            dfs(y);
        }
    }

    static void pro(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
               visited[j] = false;
            }
            dfs(i);
            for(int j=1; j<=N; j++){
                 if(visited[j]) {
                     System.out.print(1 + " ");
                 }else {
                     System.out.print(0 + " ");
                 }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
