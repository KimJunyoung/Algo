package list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class YosePuss_prac {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 1;
        int index = 0;

        // 값 저장
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<=N; i++){
            arrayList.add(i);
        }



        while(arrayList.size() >= 0){

            if(N == 1 && K == 1) {
                System.out.println("<" +"1"+">");
                break;
            }

            count ++;
            index ++;

            if(index == arrayList.size()){
                index = 0;
            }

            if(count == K){
                if(arrayList.size() == N){
                    System.out.print("<"+arrayList.remove(index)+", ");
                } else if(arrayList.size() != 1)
                {
                    System.out.print(arrayList.remove(index)+", ");
                }
                else if(arrayList.size() == 1){
                    System.out.print(arrayList.remove(index)+">");
                }

                count = 0;
                index --;
            }

            if (arrayList.size() == 0){
                break;
            }

        }



    }
}
