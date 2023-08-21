package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlogColor {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int N = sc.nextInt();
        char blogH[] = new char[N];
        blogH = sc.next().toCharArray();

        // 연속되는 거 체크
        int checkB = 0;
        int checkR = 0;

        if(blogH[0] == 'B') checkB ++;
        for(int i=1; i<N; i++){
            if(blogH[i] == 'B' && blogH[i] == blogH[i-1]) continue;

            if(blogH[i] == 'B'){
                checkB ++;
            }
        }

        if(blogH[0] == 'R') checkR ++;
        for(int i=1; i<N; i++){
            if(blogH[i] == 'R' && blogH[i] == blogH[i-1]) continue;

            if(blogH[i] == 'R'){
                checkR ++;
            }
        }

        int sum = 0;

        sum = Math.min(checkR, checkB) + 1;


        System.out.println(sum);

    }
}
