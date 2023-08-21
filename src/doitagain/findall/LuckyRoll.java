package doitagain.findall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckyRoll {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        boolean check = true;
        //입력값
        int N = sc.nextInt();
        int M = sc.nextInt();
        // 인덱스 값
        int index = N-1;
        // 배열
        char ansArr [] = new char[N];
        Arrays.fill(ansArr, '?');
        //반복문 실행
        while (M-- > 0){
            //배열에 첫번째 값을 담는다
            //다음 숫자를 보고 이동한다
            //다른 값이 있으면 ?..
            //index를 넘어가면 0 부터 다시 시작

            // index 체크
            int howMany = sc.nextInt();
           // 값 입력
            char next = sc.next().charAt(0);
            int nextIndex = ((index - howMany) % N + N) % N;
            // 만약 해당 배열에 다른 값이 있으면? -> 바로 탈출
            if(ansArr[nextIndex] == '?'){
                ansArr[nextIndex] = next;
            }else if(ansArr[nextIndex] != next){
                System.out.println("!");
                return;
            }
            index = nextIndex;
        }

        boolean alPha[] = new boolean[26];

        for(int i=0; i<N; i++){
            if(ansArr[i] == '?') continue;
            if(alPha[ansArr[i] - 'A']){
                System.out.println("!");
                return;
            }
            alPha[ansArr[i]- 'A'] = true;
        }

        for(int i=0; i<N; i++){
            System.out.print(ansArr[(index +i) % N]);
        }

        System.out.println();

    }
}
