package graph;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Virus14502 {
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans;
    static int[][] A, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        B = 0;

        A = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        blank = new int[N*M+1][2];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                A[i][j] = sc.nextInt();
            }
        }
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                // 누락
                visit[i][j] = false;
                if(A[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    // 누락
                    visit[i][j] =true;
                }
            }
        }

        // BFS 과정
        while(!Q.isEmpty()){
            Integer X = Q.poll();
            Integer Y = Q.poll();

            for(int i=0; i<4; i++){
                int xDir = X + dir[i][0];
                int yDir = Y + dir[i][1];

                // 수정 xDir or yDir 최대값인 N, M 초과 되면 범위 초과
                if(xDir < 1 || yDir < 1 || xDir > N || yDir > M) continue;
                if(visit[xDir][yDir]) continue;
                // 수정 -> 0이면 갈필요 없으니깐 == 1이 아니라 !=0 이 맞음
                if(A[xDir][yDir] != 0) continue;

               // 누락
                visit[xDir][yDir] = true;
                Q.add(xDir);
                Q.add(yDir);
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int cnt = 0;
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++)
            if (A[i][j] == 0 && !visit[i][j]) cnt++;

            ans = Math.max(ans, cnt);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selected_cnt 개의 벽을 세웠다.
    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {  // 3 개의 벽을 모두 세운 상태
            bfs();
            return;
        }
        if (idx > B) return;  // 더 이상 세울 수 있는 벽이 없는 상태

        // 지금꺼 1로 칠하기
        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx+1, selected_cnt+1);

        // 현재꺼 0로 칠하기
        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx+1, selected_cnt);
    }

    static void pro() {
        // 모든 벽의 위치를 먼저 모아놓자.
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(A[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        // 벽을 3개 세우는 모든 방법을 확인해보자!
        dfs(1,0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}