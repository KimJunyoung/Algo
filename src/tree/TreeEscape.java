package tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 노드가 짝수나 홀수냐
 * 리프노드가 짝수이냐 홀수냐
 * 노드 짝수  :: 리프노드 짝수 패배
 * 노드 홀수 :: 리프노드 홀수 패배
 */

public class TreeEscape {

    static int N;
    static long leafCount;
    static ArrayList<Integer>[] AL ;
    static BufferedWriter bw;
    static BufferedReader br;

    public static void dfs(int x, int parent, int deep){
        if(x != 1 && AL[x].size() == 1) {
            leafCount += deep;
        }

        for (int y : AL[x]) {
            if(y == parent) continue;
            dfs(y, x, deep + 1);
        }
    }

    public static void pro() throws IOException {
        dfs(1, -1, 0);
        if(leafCount % 2 ==0) bw.write("No");
        else bw.write("Yes");

        bw.flush();
    }

    public static void input() throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
         br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        leafCount = 0L;

        AL = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            AL[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            String[] inputStr = br.readLine().split(" ");
            int a = Integer.parseInt(inputStr[0]);
            int b =  Integer.parseInt(inputStr[1]);

            AL[a].add(b);
            AL[b].add(a);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
