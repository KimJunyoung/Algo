package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stone {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();

        char[] color = sc.next().toCharArray();

        int countBlack = 0;
        int countWhite = 0;
        int nextIndex = 0;
        int ans = 0;

        for(int i=0; i<N; i++){
            while(nextIndex < N){
                if(countBlack == B && color[nextIndex] == 'B') break;
                if(color[nextIndex++] == 'W') countWhite++;
                else countBlack++;
            }
            if(countWhite >= W)
                ans = Math.max(ans, nextIndex - i);
            if(color[i] == 'W') countWhite--;
            else countBlack--;
        }

        System.out.println(ans);
    }
}
