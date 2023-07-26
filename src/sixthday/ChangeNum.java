package sixthday;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ChangeNum {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int N = scanner.nextInt();
         int charNum = 65;
        int size = num;
        int count = 0;
        char charArray[] = new char[36];
        String answer = "";

        for(int i=0; i<26; i++){
            charArray[i+10] = (char) charNum;
            charNum ++;
        }

        while(size > 0){
            size = size / N;
            count ++;
        }

        size = num;

        for(int i=0; i<count; i++){
            if(size % N >= 10){
            answer = charArray[( size % N )] + answer;
            } else
            answer = ( size % N ) + answer;
            size = size / N;
        }

        System.out.println(answer);
    }
}
