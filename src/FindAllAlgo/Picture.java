package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Picture {


        public static void main (String[]args) throws FileNotFoundException {

            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            String moveTo = sc.hasNext() ? sc.next() : "";

            boolean h[][] = new boolean[size][size];
            boolean w[][] = new boolean[size][size];

            int high = 0;
            int wide = 0;

            for(int i=0; i<moveTo.length();i++){
                char cmd = moveTo.charAt(i);
                if(cmd == 'D'){
                    if(high == size - 1) continue;
                    h[high][wide] = h[high + 1][wide] = true;
                    high++;
                } else if (cmd == 'U') {
                    if(high == 0) continue;
                    h[high][wide] = h[high - 1][wide] = true;
                    high--;
                } else if (cmd == 'R'){
                    if(wide == size - 1) continue;
                    w[high][wide] = w[high][wide + 1] = true;
                    wide++;
                } else{
                    if(wide == 0) continue;
                    w[high][wide] = w[high][wide - 1] = true;
                    wide--;
                }
            }

            for(int i=0; i< size; i++){
                String ans = "";
                for(int j=0; j< size; j++){
                    if(h[i][j]  && w[i][j] ){
                        ans += "+";
                    } else if(h[i][j]) {
                        ans += "|";
                    } else if(w[i][j]){
                        ans += "-";
                    } else {
                        ans += ".";
                    }
                }
                System.out.println(ans);
            }



        }
    }

