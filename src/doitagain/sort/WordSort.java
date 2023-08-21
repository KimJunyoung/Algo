package doitagain.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSort {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        int N = sc.nextInt();
        Set<String> arrSet = new HashSet<>();
        // 중복값을 없애기 위해 Set 에 저장
        for(int i=0; i<N; i++){
            arrSet.add(sc.next());
        }
        // Set에 저장된 값들 배열에 담기
        Iterator<String> iterator = arrSet.iterator();
        String arrString[] = new String[arrSet.size()];
        for(int i=0; i< arrSet.size(); i++){
            arrString[i] = iterator.next();
        }
        // 정렬
        Arrays.sort(arrString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        // 출력
        for (String s : arrString) {
            System.out.println(s);
        }
    }
}
