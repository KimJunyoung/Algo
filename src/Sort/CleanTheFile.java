package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CleanTheFile {

    /**
     * 1. 확장자만 걷어내자
     * 2. 확장자를 배열에 담자
     *
     * */

    static int N,M;
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> arrayList;

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for(int i=0; i<N; i++){
            String next = sc.next();
            int i1 = next.indexOf(".");
            String substring = next.substring(i1+1);
            map.put(substring, map.getOrDefault(substring,0)+1);
        }

        M = map.size();
        arrayList = new ArrayList<>(map.keySet());

        Collections.sort(arrayList);
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        for (String s : arrayList) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
