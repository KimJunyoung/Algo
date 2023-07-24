package FourthDay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortKids {
    public static void main(String[] args) throws FileNotFoundException {
        /*System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int childLength[] = new int[20];
        int sortArray[] = new int[20];
        boolean checkIt = false;

        while(firstNum-- > 0){
            int T = sc.nextInt();
            int count = 0;
            for(int i=0; i<20; i++){
                childLength[i] = sc.nextInt();
            }

            for(int i=0; i<20; i++){

                checkIt = false;
                for(int j=0; j<i; j++){
                    if(childLength[j] > childLength[i]){
                        checkIt = true;
                        for(int k=i-1 ; k>= j ; k--){
                            sortArray[k+1] = sortArray[k];
                            count ++;
                        }
                        sortArray[j] = childLength[i];
                        break;
                    }

                }
                if(checkIt == false){
                    sortArray[i] = childLength[i];
                }
            }
            System.out.println(T + " " + count);

        }
*/
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        while(P-- > 0){
            int T = sc.nextInt();
            int [] h = new int[20];
            for(int i=0; i< 20; i++){
                h[i] = sc.nextInt();
            }

            int cnt = 0;
            for(int i=0; i<20; i++){
                boolean find = false;
                for(int j=0; j<i; j++){
                    if(h[j] > h[i]){
                        int h1 = h[i];
                        for(int k= i-1; k >= j ; k--){
                            h[k+1] = h[k];
                            cnt ++;
                        }
                        h[j] = h1;
                        break;
                    }

                }

            }
            System.out.println(T + " " + cnt);
        }

        }


}
