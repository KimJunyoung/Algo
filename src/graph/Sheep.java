package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sheep {

    static int R, C, o_count, v_count, o_ans, v_ans, nothing;
    static boolean visit[][];
    static int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static char arr[][];

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        arr = new char[R][C];
        visit = new boolean[R][C];

        for(int i=0; i<R; i++){
           arr[i] = sc.next().toCharArray();
        }

        o_ans = 0;
        v_ans = 0;
        nothing = 0;
    }

    static void pro(){

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visit[i][j] && arr[i][j] != '#'){
                    o_count = 0;
                    v_count = 0;
                    dfs(i,j);
                    if(o_count == 0 && v_count == 0) nothing = 0;
                    else if(o_count > v_count) o_ans += o_count;
                    else v_ans += v_count;
                }
            }
        }

        System.out.println(o_ans + " " + v_ans);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        if(arr[x][y] == 'o') o_count ++;
        if(arr[x][y] == 'v') v_count ++;

        for(int i=0; i<4; i++){
            int xDir = x + dir[i][0];
            int yDir = y + dir[i][1];

            // 누락
            if(xDir < 0 || yDir < 0 || xDir >= R || yDir >= C) continue;
            if(visit[xDir][yDir]) continue;
            if(arr[xDir][yDir] == '#') continue;

            dfs(xDir, yDir);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
