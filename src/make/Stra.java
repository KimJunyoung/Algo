package make;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Stra {

    static int N, avg, mid, frq, rag;
    static int[] inpArr;
    static int[] check;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int index = 0;

    public static void pro(){
        avg = findAvg();
        mid = findMid();
        frq = findFreq();

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(frq);
        System.out.println(rag);
    }
    // 문제점
    public static int findAvg(){
        int sum = 0;
        for(int i=0; i<N; i++) sum += inpArr[i];

        double n = (double) N;
        double avg = sum / n ;

        return (int) Math.round(avg);
    }

    public static int findMid(){
        int a = N / 2;
        return inpArr[a];
    }

    // 문제
    public static int findFreq(){
        // 빈도 횟수는 정해졌다.
        // Maxcount 값을 구하자.

        int maxCount = Integer.MIN_VALUE;

       for(int i=0; i<8002; i++){
           if(check[i] <= 0) continue;

           maxCount = Math.max(maxCount, check[i]);
       }

        for(int i=0; i<8002; i++){
            if(check[i] <= 0) continue;

            if(check[i] == maxCount) arrayList.add(i - 4000);
        }

       Collections.sort(arrayList);

       if(arrayList.size() > 1) return arrayList.get(1);
       else return arrayList.get(0);

    }


    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        inpArr = new int[N];
        check = new int[8002];
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;


        for(int i=0; i<N; i++){
            inpArr[i] = sc.nextInt();
            check[inpArr[i] + 4000] += 1;

            small = Math.min(small, inpArr[i]);
            big = Math.max(big,inpArr[i]);
        }

        Arrays.sort(inpArr);

        rag = Math.abs(big - small);

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
