package Sort;

import java.io.*;
import java.util.*;

public class Pressure {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[size];
        int copy[] = new int[size];
        int sequence =0;
        String[] s = br.readLine().split(" ");

        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(s[i]);
            copy[i] = arr[i];
        }

        Arrays.sort(arr);

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(arr[0], sequence++);
        for(int i=1; i<size; i++){
            if(arr[i-1] == arr[i]){
                integerMap.put(arr[i],integerMap.get(arr[i-1]));
            }else {
                integerMap.put(arr[i],sequence++);
            }

        }

        for(int i=0;i<size;i++){
            bw.write(integerMap.get(copy[i]) + " ");
        }
        bw.flush();

    }
}
