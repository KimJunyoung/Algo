package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Break {

    static int R, C;
    static boolean visited[][];
    static char arr[][];
    static int dist_water[][], dist_go[][];
    static int dir[][] = {{-1,0}, {0,1},{1,0},{0,-1}};

    static void gosum_bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                dist_go[i][j] = -1;
                visited[i][j] = false;

                if(arr[i][j] == 'S'){
                    queue.add(i);
                    queue.add(j);
                    dist_go[i][j] = 0;
                    visited[i][j] = true;
                }

            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0; i<4; i++){
                int xDir = x + dir[i][0];
                int yDir = y + dir[i][1];

                if (xDir < 0 || yDir < 0 || xDir >= R || yDir >= C) continue;  // 지도를 벗어나는 곳으로 가는가?

                if(arr[xDir][yDir] != '.' && arr[xDir][yDir] != 'D') continue;

                if(dist_water[xDir][yDir] != -1 && dist_water[xDir][yDir] <= dist_go[x][y] + 1) continue;

                if(visited[xDir][yDir]) continue;

                queue.add(xDir);
                queue.add(yDir);
                visited[xDir][yDir] = true;
                dist_go[xDir][yDir] = dist_go[x][y] + 1;
            }
        }

//        while (!queue.isEmpty()) {
//            int x = queue.poll();
//            int y = queue.poll();
//
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dir[k][0];
//                int ny = y + dir[k][1];
//
//                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;  // 지도를 벗어나는 곳으로 가는가?
//                if (arr[nx][ny] != '.' && arr[nx][ny] != 'D') continue;  // 갈 수 있는 칸인지 확인해야 한다.
//                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_go[x][y] + 1) continue;  // 물에 잠기지는 않는가?
//                if (visited[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
//                queue.add(nx);
//                queue.add(ny);
//                visited[nx][ny] = true;
//                dist_go[nx][ny] = dist_go[x][y] + 1;
//            }
//        }
    }

    static void water_bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                visited[i][j] = false;
                dist_water[i][j] = -1;
                if(arr[i][j] == '*') {
                    queue.add(i);
                    queue.add(j);
                    dist_water[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (arr[nx][ny] != '.') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visited[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        visited = new boolean[R][C];
        arr = new char[R][C];
        dist_water = new int[R][C];
        dist_go = new int[R][C];

        for(int i=0; i<R; i++){
            arr[i] = sc.next().toCharArray();
        }

    }

    static void pro(){

        water_bfs();

        gosum_bfs();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'D') {
                    if(dist_go[i][j] == -1 ) System.out.println("KAKTUS");
                    else System.out.println(dist_go[i][j]);
                }
            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
