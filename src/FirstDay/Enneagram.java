package FirstDay;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Enneagram {
    public static void main(String[] args) throws FileNotFoundException{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] acheck = new int[26];
        int[] bcheck = new int[26];

        for(int i=0; i<a.length(); i++) {
            acheck[a.charAt(i) - 'a']++;
        }

        for(int i=0; i<b.length(); i++) {
            bcheck[b.charAt(i) - 'a']++;
        }

        int answer = 0;
        for(int i=0; i<acheck.length; i++) {
            answer += Math.abs(acheck[i]-bcheck[i]);
        }



        System.out.println(answer);

    }
}
