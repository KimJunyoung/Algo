package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Point {

    static int N;
    static ArrayList<Integer>[] arrayLists;

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arrayLists = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            arrayLists[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=N; i++){
            int num, color;
            num = sc.nextInt();
            color = sc.nextInt();

            arrayLists[color].add(num);
        }

    }

    public static void pro(){
        // 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(arrayLists[i]);
        }

        int ans = 0;

        for(int i=1; i<=N; i++){
            for(int j=0; j<arrayLists[i].size(); j++){
               ans += legnthCheck(j, arrayLists[i]);
            }
        }

        System.out.println(ans);

    }

    public static int legnthCheck(int a, ArrayList<Integer> arrayList){
        int leftLength = Integer.MAX_VALUE;
        int rightLength = Integer.MAX_VALUE;


        if(a - 1 >= 0) {
            leftLength = arrayList.get(a) - arrayList.get(a-1);
        }

        if(a + 1 < arrayList.size()){
            rightLength = arrayList.get(a+1) - arrayList.get(a);
        }
        return Math.min(leftLength,rightLength);
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
