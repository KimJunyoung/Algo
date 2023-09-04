package doitagain.twopointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DnaPassword {

    static Integer changeNum(char c){
        if(c == 'A') return 0;
        if(c == 'C') return 1;
        if(c == 'G') return 2;
        if(c == 'T') return 3;
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int S = sc.nextInt();
        int P = sc.nextInt();

        char[] str = sc.next().toCharArray();

        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();

        // 투포인터 알고리즘

        int[] checkArray = new int[4];

        // 기본 슬라이딩을 만들어준다.
        for(int i=0; i<P-1; i++){
            checkArray[changeNum(str[i])]++;
        }

        int count = 0;

        // 거기서 한놈을 추가하고 확인하고 처음 인덱스 옮겨주는 흐름으로 진행
        for(int i = P-1; i<S; i++){
            checkArray[changeNum(str[i])]++;

            if(isInclude(checkArray,A,C,G,T)){
                count ++;
            }

            checkArray[changeNum(str[i-P+1])]--;
        }

        System.out.println(count);

    }

    static boolean isInclude(int arr[], int a, int c, int g, int t){
        if(arr[0] >= a && arr[1] >= c && arr[2] >= g && arr[3] >= t){
            return true;
        }
        return false;
    }
}
