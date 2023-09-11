package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaterBottle {

    static int A,B,C;
    static int[] limit;
    static boolean check[][][] = new boolean[205][205][205];
    static boolean possible[] = new boolean[205];


    static void bfs(int a, int b, int c){
        check[a][b][c] = true;

        Queue<State> que = new LinkedList<>();
        que.add(new State(new int[]{a,b,c}));

        while(!que.isEmpty()){
            State st = que.poll();
            if(st.X[0] == 0) possible[st.X[2]] = true;

            for(int from = 0 ; from <3; from++){
                for(int to = 0 ; to<3; to++){
                    //누락
                    if(to == from) continue;
                    State move = st.move(from, to, limit);

                    if(!check[move.X[0]][move.X[1]][move.X[2]]) {
                        check[move.X[0]][move.X[1]][move.X[2]] = true;
                        que.add(move);
                    }
                }
            }
        }
    }

    static void pro(){
        bfs(0,0,C);
        for(int i=0; i<possible.length; i++){
           if(possible[i]) System.out.print(i + " ");
        }
    }

    static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        limit = new int[3];
        limit[0] = A;
        limit[1] = B;
        limit[2] = C;
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
    }
}

    class State {
        int X[] = new int[3];

        public State(int[] X_) {
            for(int i=0; i<X_.length; i++){
                X[i] = X_[i];
            }
        }

        public State move(int from, int to, int[] limit){

            int[] nX = new int[]{X[0], X[1], X[2]};

            if(X[from] + X[to] > limit[to]){
                nX[from] -= limit[to] - X[to];
                nX[to] = limit[to];
            }else {
                nX[from] = 0;
                nX[to] = X[to] + X[from];
            }
            return new State(nX);
        }

    }
