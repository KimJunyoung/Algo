package list;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class YosePush {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> survivors = new ArrayList<>();

        for(int i= 1; i<=N; i++){
            survivors.add(i);
        }

        int[] ans = new int[N];
        int currentIndex = 0;
        for(int i=0; i<N; i++){
            currentIndex = (currentIndex + K - 1) % survivors.size();
            ans[i] = survivors.remove(currentIndex);
        }

        System.out.print("<");
        for (int i=0; i<N; i++){
            if(i>0) System.out.print(", ");
            System.out.print(ans[i]);
        }
        System.out.println(">");



    Map<String, Integer> arrMap = new HashMap<>();
    }
}
