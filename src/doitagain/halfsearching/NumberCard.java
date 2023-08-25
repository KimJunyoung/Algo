package doitagain.halfsearching;

import java.io.*;
import java.util.Arrays;

public class NumberCard {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 값
        int N = Integer.parseInt(br.readLine());
        String[] firstArrayInput = br.readLine().split(" ");
        int arrOrigin[] = new int[N];

        for(int i=0; i<N; i++){
            arrOrigin[i] = Integer.parseInt(firstArrayInput[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] secondArrayInput = br.readLine().split(" ");
        int arrCheck[] = new int[M];

        for(int i=0; i<M; i++){
            arrCheck[i] = Integer.parseInt(secondArrayInput[i]);
        }

        // 젇렬
        Arrays.sort(arrOrigin);

        //반복문 실행
        for(int i=0; i<M; i++){
            int lastIndex = UpperIndex(arrOrigin, arrCheck[i]);
            int firstIndex = LowerIndex(arrOrigin, arrCheck[i]);

            bw.write(lastIndex - firstIndex + " ");
        }

        bw.flush();
    }

    static Integer UpperIndex(int arr[], int target){
        int findIndex = arr.length;
        int l = 0, r = arr.length-1;

        while(l<=r){
            int m = (l+r) / 2;
            if(arr[m] <= target){
                l = m+1;
            }else {
                r = m-1;
                findIndex = m;
            }
        }
        return  findIndex;

    }

    static Integer LowerIndex(int arr[], int target){
        int findIndex = arr.length;
        int l = 0, r = arr.length-1;

        while(l<=r){
            int m = (l+r) / 2;
            if(arr[m] < target){
                l = m+1;
            }else {
                r = m-1;
                findIndex = m;
            }
        }
        return  findIndex;
    }
}
