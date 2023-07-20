package FirstDay;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FindDocument {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //char[] a = sc.nextLine().toCharArray();
        String a = sc.nextLine();
        String b = sc.nextLine();

        /* 내가 한 시도
        String makeString = "";
        int countNum = 0;


        for(int i=0; i<a.length-b.length()+1; i++){

            for(int j=0; j<b.length(); j++){
              makeString += a[j+i];
            }
            if(makeString.equals(b)){
                countNum += 1;
                i = i + (b.length()-1);
            }
            makeString ="";
        }

        System.out.println(countNum);
*/

        /* 강의 답안 1
        int count = 0 ;

        for(int i=0; i<a.length(); i++){
            boolean isMatch = true;
            for(int j=0; j<b.length(); j++){
                if(j+i>=a.length() || a.charAt(j+i) != b.charAt(j)){
                   isMatch = false;
                   break;
                }
            }
            if(isMatch){
                count ++;
                i = i+ b.length() - 1;
            }

        }
        System.out.println(count);
        */

        int count = 0;
        int startIndex = 0;
        int findIndex =0;

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
