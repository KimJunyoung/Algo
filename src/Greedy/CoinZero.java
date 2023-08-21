package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoinZero {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        int coinNum = sc.nextInt();
        int coinValue = sc.nextInt();
        int arr[] = new int[coinNum];
        for(int i=0; i<coinNum; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int coinRemain = coinValue;
        // 동전의 갯수 만큼 루프를 돈다
        for(int i= coinNum-1; i>=0; i--){
         // 각 배열에 저장되어 있는 동전의 종류(X) 를 돈이랑 나눔
            count += coinRemain / arr[i];
            coinRemain = coinRemain % arr[i];
         // 몫은 count 에 저장 , 나머지는 coinRemain 에 저장
            if(coinRemain == 0){
                break;
            }
        }

        System.out.println(count);

    }

}
