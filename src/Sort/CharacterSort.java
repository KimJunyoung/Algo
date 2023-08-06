package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class CharacterSort {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int sizeSort = sc.nextInt();
        String arrayFirst[] = new String[sizeSort];

        for(int i=0; i<sizeSort; i++){
            arrayFirst[i] = sc.next();
        }

        Arrays.sort(arrayFirst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });
        System.out.println(arrayFirst[0]);
        for(int i=1; i<sizeSort; i++){
            if(!arrayFirst[i].equals(arrayFirst[i-1])){
                System.out.println(arrayFirst[i]);
            }
        }


/*
        int sizeSort = sc.nextInt();
        String arrayFirst[] = new String[sizeSort];

        for(int i=0; i<sizeSort; i++){
            arrayFirst[i] = sc.next();
        }

        // 삽입 정렬
        for(int i=1; i<sizeSort; i++){
            for(int j=0; j<i; j++){
                if(arrayFirst[j].length() > arrayFirst[i].length()){
                    String a = arrayFirst[i];
                    for(int k = i; k > j; k--){
                        arrayFirst[k] = arrayFirst[k-1];
                    }
                    arrayFirst[j] = a;
                    break;
                }
            }
        }
        for(int i=0; i<sizeSort;i++){
            System.out.println(arrayFirst[i]);
        }
        System.out.println();
        //삭제
        for(int i=0; i<arrayFirst.length ; i++){
            for(int j=i; j< arrayFirst.length ; j++){
                if(arrayFirst[i].equals(arrayFirst[j])){
                    for(int k=j; k< arrayFirst.length; k++){
                        arrayFirst[j] = arrayFirst[j+1];
                        arrayFirst;
                    }
                }
            }
        }


        // 사전순 정렬
        for(int i=0; i<sizeSort-1; i++){
            boolean check = true;
            if(arrayFirst[i].length() == arrayFirst[i+1].length()){
                for(int j=0; j<arrayFirst[i].length(); j++){
                    if(arrayFirst[i].charAt(j) == arrayFirst[i+1].charAt(j)){
                        continue;
                    } else if(arrayFirst[i].charAt(j) > arrayFirst[i+1].charAt(j)){
                        String b = "";
                        b = arrayFirst[i+1];
                        arrayFirst[i+1] = arrayFirst[i];
                        arrayFirst[i] = b;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<sizeSort;i++){
            System.out.println(arrayFirst[i]);
        }
*/

    }
}
