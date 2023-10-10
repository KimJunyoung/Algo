package tree;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ArrayList 저장
 *  가장 깊게 들어가서 확인 (Size = 1 ? )
 */
public class FindParentTree {

    static int N;
    static ArrayList<Integer> arrayList[];
    static ArrayList<Integer> ans[];

    public static void dfs(int x, int parent){

        for(int y : arrayList[x]){
            if(y == parent){
                ans[x].add(y);
                continue;
            }
            dfs(y, x);
        }

    }

    public static void pro(){
        dfs(1, -1);
        for(int i=1; i<=N; i++){
            for(int integer : ans[i]){
                System.out.println(integer);
            }
        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arrayList = new ArrayList[N+1];
        ans = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            arrayList[i] = new ArrayList<>();
            ans[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
