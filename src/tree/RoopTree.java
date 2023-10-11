package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoopTree {

    static int N;
    static ArrayList<Integer>[] chr;
    static ArrayList<Character> leftAns;
    static ArrayList<Character> midAns;
    static ArrayList<Character> rightAns;

    public static void leftDfs(int x){
        if(x == -19) return;

        int a = chr[x].get(0);
        int b = chr[x].get(1);
        leftAns.add((char) (x + 'A'));
        leftDfs(a);
        leftDfs(b);
    }


    public static void rightDfs(int x){
        if(x == -19) return;

        int a = chr[x].get(0);
        int b = chr[x].get(1);
        rightDfs(a);
        rightDfs(b);
        rightAns.add((char) (x + 'A'));
    }

    public static void middleDfs(int x){
        if(x == -19) return;

       int a = chr[x].get(0);
       int b = chr[x].get(1);
       middleDfs(a);
       midAns.add((char) (x + 'A'));
       middleDfs(b);

    }



    public static void pro(){
        leftDfs(0);
        for (Character leftAn : leftAns) {
            System.out.print(leftAn);
        }

        System.out.println();

        middleDfs(0);
        for (Character midAn : midAns) {
            System.out.print(midAn);
        }

        System.out.println();

        rightDfs(0);
        for (Character rightAn : rightAns) {
            System.out.print(rightAn);
        }

    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chr = new ArrayList[N];
        leftAns = new ArrayList<>();
        rightAns = new ArrayList<>();
        midAns = new ArrayList<>();

        for(int i=0; i<N; i++){
            chr[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
             char a = sc.next().charAt(0);
             char b = sc.next().charAt(0);
             char c = sc.next().charAt(0);

             // . -> -19
            chr[a - 'A'].add(b - 'A');
            chr[a - 'A'].add(c - 'A');
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
