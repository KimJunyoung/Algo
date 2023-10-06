package Sort;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PointSort {

    static int N;
    static Point[] inpArr;

    static class Point implements Comparable<Point> {

        int x ;
        int y;

        @Override
        public int compareTo(Point o) {
            if(x == o.x) return y - o.y;
            return x - o.x;
        }
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        inpArr = new Point[N];

        for(int i=0; i<N; i++){

            int x = sc.nextInt();
            int y = sc.nextInt();

            inpArr[i] = new Point();

            inpArr[i].x = x;
            inpArr[i].y = y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        Arrays.sort(inpArr);
        for(int i=0; i<N; i++){
            System.out.println(inpArr[i].x + " " + inpArr[i].y);
        }
    }
}
