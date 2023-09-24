package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MakePassword_prac {

    // 모음 최소 한개, 자음 최소 두개의 조합 만들기 -> 조합 전체를 만들고 체크를 하자.
    // 조합 진행시 정렬 해야함 (중복 X, 숫자 선택이랑 동일)

    static int M,N;
    static char[] selected, inputArr, isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void rec_func(int k){
        if(k == M+1){
            int monCount = 0;
            int ZaCount = 0;

            for(int i=1; i<=M; i++) {
                if ((char) selected[i] == 'a' || (char) selected[i] == 'e' || (char) selected[i] == 'i'
                        || (char) selected[i] == 'o' || (char) selected[i] == 'u') {
                    monCount++;
                } else {
                    ZaCount++;
                }
            }

            System.out.print(monCount + " " + ZaCount +" ");

            if(monCount >=1 && ZaCount >=2){
                for(int i=1; i<=M; i++){
                    System.out.print((char) selected[i] + " ");
                }
                System.out.println();
            }
        }else {
            for(int cond = 1; cond <= N; cond++){
                if(isUsed[inputArr[cond]] == 1) continue;
                if(selected[k-1] < inputArr[cond]) {
                    selected[k] = inputArr[cond];
                    isUsed[inputArr[cond]] = 1;

                    rec_func(k+1);

                    isUsed[inputArr[cond]] = 0;
                    selected[k] = 0;
                }
            }
        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        selected = new char[M+1];
        inputArr = new char[N+1];
        isUsed = new char[129];

        for(int i = 1; i<= N; i++) {
            inputArr[i] = sc.next().charAt(0);
        }

        Arrays.sort(inputArr);

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
    }
}
