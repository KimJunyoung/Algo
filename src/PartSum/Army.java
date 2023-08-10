package PartSum;

import java.io.*;
import java.util.Scanner;

public class Army {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        // 입력 값 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        //delta 배열 생성
        int deltaArr[] = new int[N+2];

        // 반복문 실행
        while(M-- > 0){
            // M의 입력값 받기
            int firstIndex = sc.nextInt();
            int secondIndex = sc.nextInt();
            int value = sc.nextInt();

            //delta 배열에 저장
            deltaArr[firstIndex] += value;
            deltaArr[secondIndex + 1] += -(value);

        }


        // 누적합용 배열 생성
        int acc[] = new int[N+1];

        // 누적합 반복문
        for(int i=1; i<=N; i++){
            acc[i] = acc[i-1] + deltaArr[i];
        }


        // 기존 배열이랑 합한 후 출력
        for(int i=1; i<=N; i++){
            System.out.print(acc[i]+arr[i] + " ");
        }



        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값 받기
        String firstInput [] = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);

        String[] secondInput = br.readLine().split(" ");
        int arrN [] = new int[N+1];

        for(int i=1; i<=N;i++){
            arrN[i] = Integer.parseInt(secondInput[i-1]);
        }
        // 반복 배열 생성
        int ansArr[] = new int[N+1];

        // 반복문 실행
        while(M-- > 0){
            // 조교의 쿼리 입력 값
            String[] s1 = br.readLine().split(" ");
            int firstIndex = Integer.parseInt(s1[0]);
            int secondIndex = Integer.parseInt(s1[1]);
            int value = Integer.parseInt(s1[2]);

            for(int i=firstIndex; i<=secondIndex; i++){
                ansArr[i] += value;
            }
        }

        for(int i=1; i<=N; i++){
            ansArr[i] += arrN[i];
            bw.write(ansArr[i] + " ");
        }

        bw.flush();

*/
    }
}
