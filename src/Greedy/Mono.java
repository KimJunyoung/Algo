package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mono {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String poliomino = poliomino(next);

        System.out.println(poliomino);

    }

    public static String poliomino(String s){
        String A = "AAAA", B = "BB";
        s = s.replaceAll("XXXX", A);
        String ans = s.replaceAll("XX", B);

        if(ans.contains("X")){
            ans = "-1";
        }

        return ans;
    }
}
