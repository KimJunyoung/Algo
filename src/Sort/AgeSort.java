package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AgeSort {
    private int age ;
    private String name;

    AgeSort(int a, String n){
        age = a;
        name = n;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        AgeSort[] ageCheck = new AgeSort[size];
        for(int i=0; i<size; i++){
            ageCheck[i] = new AgeSort(sc.nextInt(), sc.next());
        }

        Arrays.sort(ageCheck, new Comparator<AgeSort>() {
            @Override
            public int compare(AgeSort o1, AgeSort o2) {
                if(o1.age == o2.age)
                    return o2.name.compareTo(o1.name);
                return o1.age - o2.age;
            }
        });

        for(int i=0; i<size; i++){
            System.out.print(ageCheck[i].age + " ");
            System.out.print(ageCheck[i].name+"\n");
        }
    }
}


