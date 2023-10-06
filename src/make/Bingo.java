package make;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  빙고 판은 5 X 5 고정
 *  구현해야하는 로직
 *      대각선 체크 (좌 / 우)
 *      행 체크
 *      열 체크
 *      체크 된게 3개 이상인가 ?
 */
public class Bingo {

    static int[][] bingo;
    static boolean[][] check;
    static int input, count;
    static boolean hey;

    public static void pro(){

        for(int i=1; i<=5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (bingo[i][j] == input) check[i][j] = true;
            }
        }

        int dia = checkDiagonal();
        int col = checkCol();
        int row = checkRow();
        count ++;

        if(dia + col + row >= 3) hey = true;
    }

    public static int checkCol(){
        int count = 0;

        for(int i=1; i<=5; i++){
            boolean checkit = false;
            for(int j=1; j<=5; j++){
                if(!check[i][j]) {
                    checkit = false;
                    break;
                }
                checkit = true;
            }
            if(checkit) count++;
        }
        return count;
    }

    public static int checkRow(){
        int count = 0;

        for(int i=1; i<=5; i++){
            boolean checkit = false;
            for(int j=1; j<=5; j++){
                if(!check[j][i]) {
                    checkit = false;
                    break;
                }
                checkit = true;
            }
            if(checkit) count++;
        }
        return count;
    }

    public static int checkDiagonal(){
        int checkLeft = 0;
        int checkRight = 0;

        if(check[1][1] && check[2][2] && check[3][3] && check[4][4] && check[5][5]) checkRight = 1;
        if(check[5][1] && check[4][2]&& check[3][3]&& check[2][4]&& check[1][5]) checkLeft = 1;

        return checkLeft + checkRight;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // Input
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        bingo = new int[6][6];
        check = new boolean[6][6];
        hey = false;
        count = 0;

        // bingo
        for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++){
                bingo[i][j] = sc.nextInt();
            }
        }
        int a = 25;
        while(a -- > 0){
            input = sc.nextInt();
            pro();
            if(hey) break;
        }

        System.out.println(count);
    }
}
