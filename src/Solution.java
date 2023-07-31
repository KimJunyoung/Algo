import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {


        public String solution(String str1, String str2) {
            String answer = "";

            for(int i=0; i< str1.length();i++){
                answer =  answer + (("" + str1.charAt(i)) + ("" + str2.charAt(i)));
            }
            return answer;
        }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/inputSolution.txt"));
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

    }
}