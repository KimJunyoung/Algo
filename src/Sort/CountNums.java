package Sort;

import java.io.*;
import java.util.*;

public class CountNums {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int numMax = sc.nextInt();

        LinkedHashMap<Integer, Integer> messages = new LinkedHashMap<>();
        for(int i=0; i<N; i++){
            int message = sc.nextInt();
            messages.put(message, messages.getOrDefault(message,0)+1);
        }

        Integer[] frequencies = messages.keySet().toArray(new Integer[messages.size()]);
        Arrays.sort(frequencies, (o1, o2) -> messages.get(o2)-messages.get(o1));

        for (Integer frequency : frequencies) {
            int count = messages.get(frequency);
            while(count -- > 0)
                System.out.print(frequency + " ");
        }
    }
}
