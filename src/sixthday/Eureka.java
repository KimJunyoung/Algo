package sixthday;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Eureka {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));

        Scanner sc = new Scanner(System.in);
        int lineSize = sc.nextInt();
        int eurekaArray[] = new int[45];

        while(lineSize-- > 0 ){
            int wantToFind = sc.nextInt();
            boolean check = false;

            for(int i=0; i<45;i++){
                eurekaArray[i] = ((i*(i+1))/2);
            }

            for(int i=1; i<45; i++){
                for(int j=1; j<45; j++){
                    for(int k=1; k<45; k++){
                        if(wantToFind == (eurekaArray[i]+eurekaArray[j]+eurekaArray[k])){

                                check = true;

                            break;
                        }
                    }

                }

            }
            if(check){
                System.out.println(1);
            } else if(!check) {
                System.out.println(0);
            }
        }



    }
}
