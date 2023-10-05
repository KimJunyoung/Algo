package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SerialNumber {

    static int N;
    static String[] arrStr;


    public static void pro(){

        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                } else {
                    int o1Sum = -1;
                    int o2Sum = -1;

                    char[] o1CharArr = o1.toCharArray();
                    char[] o2CharArr = o2.toCharArray();


                    for(int i=0; i<o1CharArr.length; i++){
                        if((int) o1CharArr[i] < 60) {
                            o1Sum += (int) o1CharArr[i] - 48;
                        }
                        if((int) o2CharArr[i] < 60){
                            o2Sum += (int)  o2CharArr[i] - 48;
                        }
                    }

                    if(o1Sum == o2Sum){
                        return o1.compareTo(o2);
                    }else {
                        return o1Sum - o2Sum;
                    }
                }
            }
        });

        for (String s : arrStr) {
            System.out.println(s);
        }

    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arrStr = new String[N];

        for(int i=0; i<N; i++){
            arrStr[i] = sc.next();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}
