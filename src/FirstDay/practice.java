package FirstDay;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class practice {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        int count = 0;
        int startIndex =0;
        int findIndex = 0;

        while(true){
            findIndex = a.indexOf(b, startIndex);
            if(findIndex<0){
                break;
            }
            startIndex = findIndex + b.length();
            count ++;
        }

        System.out.println(count);


    }
}