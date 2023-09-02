package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeTry {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int T = sc.nextInt();

        while(T-- > 0){
            int checkBool = 0;
            int checkCount = 0;

            String[] checkArray = sc.next().split("");

            int leftIndex = 0;
            int rightIndex = checkArray.length - 1;

            while(leftIndex < rightIndex){
                if(checkEquals(checkArray, leftIndex, rightIndex)){
                    leftIndex ++;
                    rightIndex --;
                }
                if(!checkEquals(checkArray, leftIndex, rightIndex)){
                    checkCount ++;
                    if(checkCount > 1){
                        checkBool = 2;
                        break;
                    }

                    leftIndex++;
                    if(checkEquals(checkArray, leftIndex, rightIndex)){
                        checkBool = 1;
                        continue;
                    }else{
                        leftIndex--;
                        rightIndex--;
                        if(checkEquals(checkArray, leftIndex,rightIndex)){
                            checkBool = 1;
                            continue;
                        }else{
                            checkBool = 2;
                            break;
                        }
                    }
                }
            }
            System.out.println(checkBool);
        }
    }

    public static boolean checkEquals(String[] arr, int left, int right){
        return arr[left].equals(arr[right]);
    }
}
