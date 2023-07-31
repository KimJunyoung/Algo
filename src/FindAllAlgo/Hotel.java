package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        while(P-->0){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int roomNum = sc.nextInt();
            int roomH =  ( roomNum % H );
            int roomW =  ( roomNum / H ) +1 ;

            if(roomH == 0){
                roomH = H;
                roomW = roomW -1 ;
            }

            System.out.print(roomH);
            if(roomW < 10){
                System.out.print("0"+roomW+"\n");
            } else {
                System.out.print(roomW+"\n");
            }
            }
        }

    }



