package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeChess {

    static int N, M, min;
    static String[] str;

    static int mainFunction(int startIndex, int lastIndex, String[] str){
            String[] answerString = {"WBWBWBWB", "BWBWBWBW"};
            int changeCount = 0;

            for(int i = 0; i < 8; i++){
                    int row = startIndex + i;
                for(int j=0; j< 8; j++){
                    int col = lastIndex + j;
                    if(str[row].charAt(col) != answerString[row % 2].charAt(j)) changeCount ++;
                }
            }

            return Math.min(changeCount, 64 - changeCount);

    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        str = new String[N];

        for (int i = 0; i < N; i++) str[i] = sc.next();

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();

        min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 배열을 만들어서 서로 비교해주는 로직 구현
                int result = mainFunction(i, j, str);
                if(min > result) min = result;
            }
        }

        System.out.println(min);
    }
}
