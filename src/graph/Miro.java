package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro {

     static int N, M, count;
     static boolean visited[][];
     static int arr[][];
     static int dist[][];
     static int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

     static void input() throws FileNotFoundException {
         System.setIn(new FileInputStream("src/input.txt"));
          Scanner sc = new Scanner(System.in);

          N = sc.nextInt();
          M = sc.nextInt();
          arr = new int[N+1][M+1];
          visited = new boolean[N+1][M+1];
          dist = new int[N+1][M+1];

          for(int i=1; i<= N; i++){
              String[] split = sc.next().split("");
              for(int j=1; j<=M; j++){
                  arr[i][j] = Integer.parseInt(split[j-1]);
              }
          }

     }

     static void pro(){
        bfs(1,1);
         System.out.println(dist[N][M]);
     }

     static void bfs(int x, int y){
         /**
          * 누락
          * 초기화 실행
          * 방문하지 않은 곳 출력했을 때 NullPointException 발생 보다 낫다.
          */
         for(int i=1; i<=N ; i++){
             for(int j=1; j<=M; j++){
                 dist[i][j] = -1;
             }
         }

         Queue<Integer> que = new LinkedList<>();

         que.add(x);
         que.add(y);
         dist[x][y] = 1;
         visited[x][y] = true;

         while(!que.isEmpty()){
             int a = que.poll();
             int b = que.poll();

                for(int i=0; i<4; i++){
                int xDir = a + dir[i][0];
                int yDir = b + dir[i][1];

                if(xDir < 1 || yDir < 1 || xDir > N || yDir > M) continue;
                if(visited[xDir][yDir]) continue;
                if(arr[xDir][yDir] != 1) continue;
                visited[xDir][yDir] = true;
                dist[xDir][yDir] = dist[a][b] + 1;
                    que.add(xDir);
                    que.add(yDir);
             }
         }
     }

     public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
     }
}
