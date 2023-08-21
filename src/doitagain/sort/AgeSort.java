package doitagain.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AgeSort {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        int N = sc.nextInt();
        Person arrPerson[] = new Person[N];
        // 객체에 나이랑 이름을 넣어서
        for(int i=0; i<N;i++){
            arrPerson[i] = new Person(sc.nextInt(), sc.next());
        }
        // 나이순으로 정렬하자. 어차피 가입한 순이면 Arrays.sort때 지켜진다
        Arrays.sort(arrPerson, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for(int i=0; i<N;i++){
            System.out.println(arrPerson[i].age + " " + arrPerson[i].name);
        }

    }
}

class Person {
    int age ;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}