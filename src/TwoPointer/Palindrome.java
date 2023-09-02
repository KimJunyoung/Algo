package TwoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력 값
        int T = sc.nextInt();

        while (T-- > 0) {
            String[] str = sc.next().split("");

            int ans = 0;
            int l = 0;
            int r = str.length - 1;

            while(l<=r){
                if(!str[l].equals(str[r])){
                    if(isPalindrome(str,l+1,r) || isPalindrome(str, l, r-1)){
                        ans = 1;
                    } else{
                        ans = 2;
                    }
                    break;
                }

                l ++;
                r --;
            }
            System.out.println(ans);
        }
    }

    static boolean isPalindrome(String[] str, int l, int r){
        while(l<=r){
            if(!str[l].equals(str[r])) return false;
            l++;
            r--;
        }

        return true;
    }
}
