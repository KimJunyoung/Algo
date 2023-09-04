package doitagain.halfsearching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MoneyCheck {

    // m 이 인출한 돈이라고 가정하면, m 으로 N일간 몇번 뽑아야 하는지 체크. 숫자가 많으면 문제가 되지만 적으면 넣었다 뻈다 하면 되기 때문에 상관없다.
    static boolean countBank(int arr[], int m, int M){
        // 첫날에는 무조건 출금을 해야하기 때문에 count = 1
        int count = 1;
        int haveMoney = m;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > m){
                return false;
            }

            if(haveMoney < arr[i]){
                haveMoney = m;
                count ++;
            }

            haveMoney -= arr[i];

        }

        if(count > M){
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 이분탐색 알고리즘
        int l = 0, r = N * 10000, trg = 0;
        while(l<=r){
            int m = (l+r)/2;
            if(countBank(arr, m, M)){
                r = m - 1;
                trg = m;
            }else {
                l = m + 1;
            }
        }

        System.out.println(trg);
    }
}
