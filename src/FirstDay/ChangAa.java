package FirstDay;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ChangAa {

    public static void main(String[] args) throws FileNotFoundException{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)>='A' && a.charAt(i)<= 'Z') {
                System.out.print((char)('a' + a.charAt(i) - 'A'));
            }else System.out.print((char)('A' + a.charAt(i) - 'a'));
        }


    }
}
