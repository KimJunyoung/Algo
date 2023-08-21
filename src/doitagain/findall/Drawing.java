package doitagain.findall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        //입력값 받기
        int N = sc.nextInt();
        String next ;

        if(sc.hasNext()){
            next = sc.next();
        } else {
            next = "";
        }

        char[] drawing = next.toCharArray();


        // 상하, 좌우 배열 만들기
        char upAndDown [][] = new char[N][N];
        char rightAndLeft [][] = new char[N][N];

        // index 값
        int upDown = 0;
        int rightLeft = 0;

        //반복문 실행
        for(int i=0; i<drawing.length;i++){

            // 분기 문 실행
            if(drawing[i] == 'D' || drawing[i] == 'U'){

                if(drawing[i] == 'D' ){
                    if(upDown + 1 > N-1){
                        continue;
                    }
                    upAndDown[upDown][rightLeft] = (char) 124;
                    upDown ++;
                    upAndDown[upDown][rightLeft] = (char) 124;
                }

                if(drawing[i] == 'U'){

                    if(upDown -1 < 0){
                        continue;
                    }
                    upAndDown[upDown][rightLeft] = (char) 124;
                    upDown --;
                    upAndDown[upDown][rightLeft] = (char) 124;

                }
            }

            if(drawing[i] == 'L' || drawing[i] == 'R'){

                if(drawing[i] == 'R'){
                    if(rightLeft + 1 > N-1){
                        continue;
                    }
                    rightAndLeft[upDown][rightLeft] = (char) 45;
                    rightLeft ++;
                    rightAndLeft[upDown][rightLeft] = (char) 45;
                }

                if(drawing[i] == 'L'){
                    if(rightLeft - 1 < 0){
                        continue;
                    }
                    rightAndLeft[upDown][rightLeft] = (char) 45;
                    rightLeft --;
                    rightAndLeft[upDown][rightLeft] = (char) 45;

                }

            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(upAndDown[i][j] == (char) 124 && rightAndLeft[i][j] == (char) 45){
                    System.out.print((char)43);
                } else if (upAndDown[i][j] == (char) 124) {
                    System.out.print((char)124);
                }else if(rightAndLeft[i][j] == (char) 45){
                    System.out.print((char)45);
                }else {
                    System.out.print((char)46);
                }

            }
            System.out.println();
        }

    }
}
