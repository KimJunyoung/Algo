package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    static int N, M;
    static int arr[][];
    static boolean visit[][];
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


    static void pro(){

        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    bfs(i,j);
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
            if (arr[nx][ny] == 0) continue;  // 갈 수 있는 칸인지 확인해야 한다.
            if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
            dfs(nx, ny);
        }
    }

    static void bfs(Integer x, Integer y){
        Queue<Integer> queue = new LinkedList<>();
        visit[x][y] = true;

        queue.add(x);
        queue.add(y);

        while(!queue.isEmpty()){
            Integer a =  queue.poll() ;
            Integer b =  queue.poll() ;

            for(int i=0; i<8; i++){
                int xDir = a + dir[i][0];
                int yDir = b + dir[i][1];

                if(xDir < 0 || yDir < 0 || xDir >= N || yDir >=M) continue;
                if(visit[xDir][yDir]) continue;
                if(arr[xDir][yDir] == 0) continue;

                visit[xDir][yDir] = true;

                queue.add(xDir);
                queue.add(yDir);

            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        while (true){
            M = sc.nextInt();
            N = sc.nextInt();

            if(N == 0 && M ==0) break;

            arr = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            visit = new boolean[N][M];

            pro();
        }

    }
}
