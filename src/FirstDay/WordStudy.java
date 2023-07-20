package FirstDay;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class WordStudy {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String a = sc.next().toLowerCase();
        int mostOften = 0;
        int check = 0;
        int mostOftenindex = 0;
        int[] countNumArray = new int[26];

        for(int i=0; i< a.length();i++){
            countNumArray[a.charAt(i) - 'a']++;
        }

        for(int i=0; i<countNumArray.length; i++){
            if(countNumArray[i]>mostOften){
                mostOften = countNumArray[i];
                mostOftenindex = i;
            }
        }

        for(int i=0; i<countNumArray.length; i++){
            if(countNumArray[i] == mostOften){
                check ++;
            }
        }

        if(check > 1) {
            System.out.println("?");
        }else {
            System.out.println((char) ('A' + mostOftenindex));
        }



    }
}
