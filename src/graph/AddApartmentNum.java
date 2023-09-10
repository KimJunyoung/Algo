package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddApartmentNum {


    static int N;
    static String[] arr;
    static int dir[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] check;
    static int count;
    static ArrayList<Integer> ans;
    static StringBuilder sb = new StringBuilder();


    static void dfs(int x, int y){
        count ++;
        check[x][y] = true;

        for(int i=0; i<4; i++){
            int xDir = x + dir[i][0];
            int yDir = y + dir[i][1];
            if(xDir < 0 || yDir < 0 || xDir >= N || yDir >= N) continue;
            if(check[xDir][yDir]) continue;
            //누락
            if(arr[xDir].charAt(yDir) == '0') continue;

            dfs(xDir,yDir);
        }
    }

    static void pro(){

        ans = new ArrayList<>();

        // 배열 전체 확인
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
             if(!check[i][j] && arr[i].charAt(j) == '1'){
                count = 0;
                dfs(i,j);
                ans.add(count);
             }
            }
        }

        // 누락
        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for(int i=0; i<ans.size(); i++) sb.append(ans.get(i)).append("\n");
        System.out.println(sb);

    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        N = sc.nextInt();
        arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.next();
        }

        check = new boolean[N][N];
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
