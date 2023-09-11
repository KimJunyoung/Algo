package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectLineCount {

    static int N, M, count;
    static ArrayList<Integer> arrayList[];
    static boolean check[];
    static ArrayList<Integer> ans ;
    static StringBuilder sb = new StringBuilder();

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arrayList = new ArrayList[N+1];
        for(int i=1; i<= N; i++){
            arrayList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();

            arrayList[X].add(Y);
            arrayList[Y].add(X);
        }
        check = new boolean[N+1];
        ans = new ArrayList<>();
    }

    static void pro(){
        int start = 1;
       while(N-- > 0){
           System.out.println("갔다온적이 없나요? " + !check[start] + " Not empty : " + !arrayList[start].isEmpty());
           if(!check[start] /* && !arrayList[start].isEmpty() */){ // 필요없다.
               count = 0;
               dfs(start);
               ans.add(count);
           }
           start++;
       }
        System.out.println(ans.size());
    }

    static void dfs(int x){
        check[x] = true;
        count++;

        for(int y : arrayList[x]){
            if(check[y]) continue;
            dfs(y);
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
