package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GasolineCharge {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값 저장
        int N = sc.nextInt();
        Long streetCost [] = new Long[N-1];
        Long chargeCost [] = new Long[N];

        // 거리 값 입력
        for(int i=0; i< streetCost.length; i++){
            streetCost[i] = (long) sc.nextInt();
        }

        // 주유 값 입력
        for(int i=0; i<chargeCost.length; i++){
            chargeCost[i] = (long) sc.nextInt();
        }

        Long minCharge = chargeCost[0];
        long sum = 0L;
        // 처음 값 저장 및 반복문 실행
        for(int i=0; i<N-1; i++){
           minCharge = Math.min(minCharge, chargeCost[i]);
            System.out.println(minCharge);
           sum += (minCharge * streetCost[i]);
        }

        System.out.println(sum);
    }
}
