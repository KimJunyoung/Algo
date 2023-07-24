package FourthDay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaveCathle {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();
        char[][] array = new char[firstNum][secondNum];
        for(int i=0; i<firstNum;i++){
            String string = sc.next();
            for(int j=0;j<secondNum;j++){
                array[i][j] = string.charAt(j);
            }
        }
        int checkHang = 0 ;
        int checkYeoul = 0;
        boolean check = false;
        boolean check2 = false;

        for(int i=0; i<firstNum;i++){
                check = false;
            for(int j=0; j<secondNum; j++){
                if(array[i][j] == 'X'){
                    check =  true;
                }
            }
            if(check != true){
                checkHang ++;
            }
        }

        for(int i=0; i<secondNum; i++){
                check2 = false;
            for(int j=0; j<firstNum; j++){
                if(array[j][i] == 'X'){
                    check2 = true;
                }
            }
            if(check2 != true){
                checkYeoul ++;
            }
        }

        if(checkHang > checkYeoul){
            System.out.println(checkHang);
        } else {
            System.out.println(checkYeoul);
        }


        }


    }

