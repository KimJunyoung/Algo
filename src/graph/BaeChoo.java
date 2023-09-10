package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BaeChoo {

    static int T, M, N, K, X, Y, count;
    static int arr[][] ;
    static int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean check[][];
    static ArrayList<Integer> ans;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x, int y){
         check[x][y] = true;

        for(int i=0; i<4; i++){
            int xDir = x + dir[i][0];
            int yDir = y + dir[i][1];

            if(xDir < 0 || yDir < 0 || xDir >= N || yDir >= M) continue;
            if(check[xDir][yDir]) continue;
            if(arr[xDir][yDir] == 0) continue;

            dfs(xDir, yDir);
        }

    }



    static void pro(){

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!check[i][j] && arr[i][j] == 1){
                    dfs(i,j);
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while(T -- > 0){
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            arr = new int[N][M];
            check = new boolean[N][M];
            count = 0;

            for(int i=0; i<K; i++){
                X = sc.nextInt();
                Y = sc.nextInt();

                arr[X][Y] = 1;
            }

            pro();
        }
    }
}
