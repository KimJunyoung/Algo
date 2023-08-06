package Greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiveItBack {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int coinValue = sc.nextInt();
        int count =0;
        while(true){
            if(coinValue % 5 == 0){
                count = count + coinValue / 5;
                System.out.println(count);
                break;
            }
            else if (coinValue % 5 != 0){
                coinValue -= 2;
                count ++;
            }
            if(coinValue < 0){
                System.out.println(-1);
                break;
            }

        }

        /*int coinFive = 0;
        int coinTwo = 0;
        int coinValue = sc.nextInt();

        if((coinValue%5) % 2 != 0){
            if()
            coinFive = ( coinValue / 5 ) -1;
            if(((coinValue % 5 + 5) % 2) == 0){
                coinTwo = ((coinValue % 5 + 5) / 2);
            } else {
                System.out.println(-1);
            }
        } else {
             coinFive = coinValue / 5 ;
             coinTwo = ( coinValue % 5 ) / 2;
        }

        System.out.println(coinTwo + coinFive);


*/

    }
}
