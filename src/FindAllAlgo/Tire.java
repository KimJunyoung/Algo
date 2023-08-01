package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tire {
    public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("src/input.txt"));
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int K = sc.nextInt();
            char newArray[] = new char[N];
            Arrays.fill(newArray, '?');

            int curIndex = 0;
            while (K -- > 0){
                int howMany = sc.nextInt();
                char thisChar = sc.next().charAt(0);
                int nextIndex = ((curIndex - howMany) % N + N) % N;
                if(newArray[nextIndex] == '?') newArray[nextIndex] = thisChar;
                else if(newArray[nextIndex] != thisChar){
                    System.out.println("!");
                    return;
                }
                curIndex = nextIndex;
            }

            boolean alPha[] = new boolean[26];

            for(int i=0; i<N; i++){
                if(newArray[i] == '?') continue;
                if(alPha[newArray[i] - 'A']){
                    System.out.println("!");
                    return;
                }
                alPha[newArray[i] - 'A']= true;
            }


            for(int i=0; i<N; i++){
                System.out.print(newArray[(curIndex +i) % N]);
            }

            System.out.println();


          /*
            int size = sc.nextInt();
            int tryNum = sc.nextInt();
            String array[] = new String[size];
            boolean check = true;
            int count = 0;

            while (tryNum-- > 0) {
                int howMany = sc.nextInt();
                char thisChar = sc.next().toCharArray()[0];

                count += howMany;
                if (count < size) {
                    if(array[count] != null){
                        check = false;
                        break;
                    }
                    array[count] = ""+thisChar;
                } else if (count >= size) {
                    count %= size;
                    if(array[count] != null){
                        check =false;
                        break;
                    }
                    array[count] = ""+thisChar;
                }
            }
            if(check) {

                for (int j = count; j >= 0; j--) {
                    if (array[j] == null) {
                        System.out.print("?");
                    } else {
                        System.out.print(array[j]);
                    }

                }

                for (int i = size - 1; i > count; i--) {
                    if (array[i] == null) {
                        System.out.print("?");
                    } else {
                        System.out.print(array[i]);
                    }
                }
            }

            if(!check){
                System.out.println("!");
            }
    */
    }
}