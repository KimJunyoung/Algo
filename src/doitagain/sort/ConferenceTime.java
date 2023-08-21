package doitagain.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConferenceTime {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        // 입력값
        int N = sc.nextInt();
        SeTime seTime[] = new SeTime[N];

        for(int i=0; i<N; i++){
            seTime[i] = new SeTime(sc.nextInt(), sc.nextInt());
        }

        // 정렬
        Arrays.sort(seTime, new Comparator<SeTime>() {
            @Override
            public int compare(SeTime o1, SeTime o2) {
                if(o1.endTime == o2.endTime){
                   return o1.startTime - o2.startTime;
                }

                return o1.endTime - o2.endTime;
            }
        });

        // 강의 횟수 세기
        int count = 1;
        int firstTime , secondTime;

        firstTime = seTime[0].startTime;
        secondTime = seTime[0].endTime;

        for(int i=1; i<N; i++){
            if(seTime[i].startTime >= secondTime){
                firstTime = seTime[i].startTime;
                secondTime = seTime[i].endTime;
                System.out.println(firstTime + " " + secondTime);
                count ++;
            }
        }

        System.out.println(count);
    }

    static class SeTime {
        int startTime ;
        int endTime ;

        public SeTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
