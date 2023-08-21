package binarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringGroup {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값 저장
        int inputSize = sc.nextInt();
        int checkSize = sc.nextInt();

        // Set 에 저장
        Set<String> stringSet = new HashSet<>();
        for(int i=0; i< inputSize; i++){
            stringSet.add(sc.next());
        }

        // 포함 횟수 저장
        int count = 0;

        for(int i=0; i<checkSize; i++){
            if(stringSet.contains(sc.next())){
                count ++;
            }
        }

        System.out.println(count);
    }
}
