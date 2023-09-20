package FindAllAlgo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueenMoving {

    static int N, ans;
    static int col[];


    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        col = new int[N+1];
    }

    static boolean attackPossible(int r1, int c1, int r2, int c2){
        if(c1 == c2) return true;
        if(r1 + c1 == r2 + c2) return true;
        if(r1- c1 == r2 - c2) return true;
        return false;
    }

    static boolean checkPossible(){
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                if(attackPossible(i, col[i], j, col[j])){
                    return false;
                }
            }
        }
        return true;
    }

    static void rec_func(int k){
        if(k == N+1){
            ans++;
        } else{
            for(int c=1; c<=N; c++){
                boolean possible = true;
                for(int i=1; i<=k-1; i++){
                    if(attackPossible(k,c ,i,col[i])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[k] = c;
                    rec_func(k+1);
                    col[k] = 0;
                }

            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        rec_func(1);
        System.out.println(ans);
    }

}

