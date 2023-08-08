package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class ConferenceTime {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting meetings [] = new Meeting[N];
        for(int i=0; i<N; i++){
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end){
                    return o1.start-o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int count = 0;
        int max = 0;

        for(int i=0; i<N; i++){
            if(max <= meetings[i].start){
                count++;
                max = meetings[i].end;
            }
        }

        System.out.println(count);

        /*
        int N = sc.nextInt();
        int arr[] = new int[N];
        LinkedHashMap<Integer, Integer> numbers = new LinkedHashMap<>();

        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
            numbers.put(sc.nextInt(),arr[i]);
        }

        Integer keyNum[] = numbers.keySet().toArray(new Integer[numbers.size()]); // 끝나는 시간 중복값 생각 못함
        Arrays.sort(keyNum, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        Integer numMax = keyNum[0];
        int count = 1;
        for(int i=1; i<N;i++){
            if(numbers.get(keyNum[i]) > numMax){
                count++;
                numMax = keyNum[i];
            }
        }

        System.out.println(count);

         */



    }
}
