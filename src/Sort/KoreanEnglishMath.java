package Sort;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KoreanEnglishMath {

    static int N;
    static Person[] people;

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        people = new Person[N];
        for(int i=0; i<N; i++){
            people[i] = new Person(sc.next(), sc.nextInt(), sc.nextInt(),sc.nextInt());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.Korean == o2.Korean){
                    if(o1.English == o2.English){
                        if(o1.Math == o2.Math){
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.Math - o1.Math;
                    }
                    return o1.English - o2.English;
                }
                return o2.Korean - o1.Korean;
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(people[i].name);
        }

    }


    static class Person {
        String name;
        int Korean, English, Math;

        public Person(String name, int korean, int english, int math) {
            this.name = name;
            Korean = korean;
            English = english;
            Math = math;
        }
    }

}
