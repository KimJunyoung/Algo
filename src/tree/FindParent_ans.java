package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindParent_ans {

    static int N, S, M;
    static ArrayList<Integer>[] arr;
    static ArrayList<Integer> fisrt, second,ans ;

    public static void dfs1(int x, int p) {
        if(x != S) fisrt.add(x);

        if(x != S && arr[x].size() ==1) {
            return;
        }

        for (int y : arr[x]) {
            if(y == p) continue;
            dfs1(y,x);
        }

    }
    public static void dfs2(int x, int p) {
        if(x != M) second.add(x);

        if(x != M && arr[x].size() ==1) {
            return;
        }

        for (int y : arr[x]) {
            if(y == p) continue;
            dfs2(y,x);
        }
    }



    public static void pro() {
        dfs1(S, -1);
        dfs2(M, -1);

        for(int i=0; i<fisrt.size(); i++){
            System.out.println("first " + fisrt.get(i));
            if(second.contains(fisrt.get(i))) {
                ans.add(fisrt.get(i));
            }
        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new ArrayList[N + 1];
        fisrt = new ArrayList<>();
        second = new ArrayList<>();
        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        S = sc.nextInt();
        M = sc.nextInt();

        System.out.println(S + " " + M);

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
        System.out.println(ans.get(0));

    }
}
