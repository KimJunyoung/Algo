package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  1. 값 저장
 *  2. 재귀
 *  3. 다음 값이 없을 때 count ++
 */
public class Tree {

    static int N, M, root, count;
    static int[] leaf;
    static ArrayList<Integer>[] arr;

    public static void dfs(int k) {
        if(k == M ) return;

        if(arr[k].isEmpty()) count++;

        for(int y : arr[k]){
            if(y == M) continue;
            dfs(y);
        }
    }

    public static void pro() {
        for(int i=0; i<N; i++){
            if(arr[i].contains(M)){
                arr[i].remove(arr[i].indexOf(M));
            }
        }

        if( root != M) dfs(root);
        System.out.println(count);
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        leaf = new int[N];
        arr = new ArrayList[N];

        for(int i=0; i<N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<N;i ++){
            int a = sc.nextInt();
            if(a== -1 ) {
                root = i;
                continue;
            }
            arr[a].add(i);
        }

        M = sc.nextInt();

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
