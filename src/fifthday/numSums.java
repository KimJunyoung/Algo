package fifthday;

import java.io.*;
import java.util.Scanner;

public class numSums {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));

        Scanner sc = new Scanner(System.in);

             int arraySize = sc.nextInt();
             int putNum[] = new int[arraySize];
                for(int i=0; i<arraySize; i++){
                putNum[i] = sc.nextInt();
            }
                int sumCheck = sc.nextInt();

                int arrNums [] = new int[1000001];
                int minusNum [] = new int[1000001];
                int count = 0;



                for(int i=0; i<arraySize; i++){
                    arrNums[putNum[i]]++;
                    int pairNum = sumCheck -putNum[i];

                    if(pairNum>=1 && pairNum <= 1000000){
                        minusNum[pairNum] ++;
                    }

                }

                for(int i=0; i<=1000000; i++){
                    if(minusNum[i]>0){
                            if(arrNums[i]>0){
                                count++;
                        }
                    }
                }

                System.out.println(count/2);









/*
        int arraySize = sc.nextInt();
        int[] a =new int[arraySize];
        for(int i=0; i<arraySize; i++){
            a[i] = sc.nextInt();
        }
        int sumCheck = sc.nextInt();
        int count = 0;
        int putNums [] = new int[1000001];

        for(int i=0; i<arraySize; i++){
            putNums[a[i]]++;
        }

        for(int i=0; i<arraySize; i++){
            int pairValue = sumCheck - a[i];
            if(0 <= pairValue && pairValue <= 1000000){
                count += (putNums[pairValue]>0)? 1:0;
            }
        }

        System.out.println(count/2);
*/




        /*
        boolean[] exist = new boolean[1000001];

        for(int i=0; i<arraySize; i++){
            exist[a[i]] = true;
        }

        for(int i=0; i<arraySize; i++){
            int pairValue = sumCheck - a[i];

            if(0<= pairValue && pairValue <= 1000000 ){
                count += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(count/2);
*/

        /*
        int arraySize = Integer.parseInt(br.readLine());
        int array[] = new int[arraySize];
        String arr[] = br.readLine().split(" ");
        int sumCheck = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<arraySize; i++){
            array[i] = Integer.parseInt(arr[i]);
        }



        for(int i=0; i<arraySize; i++){
            for(int j=i; j<arraySize; j++){
                if(array[i] + array[j] == sumCheck){
                    count ++;
                }
            }
        }

        System.out.println(count);
*/

    }
}
