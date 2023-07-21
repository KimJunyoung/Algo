package ThirdDay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class saltbomb {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);


        String firstArr[] = sc.next().split(":");
        String secondArr[] = sc.next().split(":");
        String answer = "";

        int firstTimeNum = 0;
        int secondTimeNum = 0;
        int mostTime = 0;



        for(int i=0; i< firstArr.length; i++){
            if(i==0){
                firstTimeNum = firstTimeNum + (3600) * (Integer.parseInt(firstArr[i]));
                secondTimeNum = secondTimeNum + (3600) * (Integer.parseInt(secondArr[i]));
            } else if(i==1){
                firstTimeNum = firstTimeNum + (60) * (Integer.parseInt(firstArr[i]));
                secondTimeNum = secondTimeNum + (60) * (Integer.parseInt(secondArr[i]));
            } else {
                firstTimeNum = firstTimeNum + (Integer.parseInt(firstArr[i]));
                secondTimeNum = secondTimeNum + (Integer.parseInt(secondArr[i]));
            }
        }

        if(secondTimeNum - firstTimeNum <= 0 ) {
            mostTime = secondTimeNum - firstTimeNum + (24 * 3600);
        } else {
            mostTime = secondTimeNum - firstTimeNum;
        }


            if(mostTime/3600 >= 10){
                answer += Integer.toString(mostTime/3600);
            } else {
                answer += ("0"+Integer.toString(mostTime/3600));
            }

                answer += ":";
            if((mostTime%3600)/60 >= 10){
                answer += Integer.toString((mostTime%3600)/60);
            } else {
                answer += ("0" + Integer.toString((mostTime%3600)/60));
            }
                answer += ":";
          if(((mostTime%3600)%60) >= 10 ){
                answer += Integer.toString(((mostTime%3600)%60));
            } else {
                answer += ("0"+ Integer.toString(((mostTime%3600)%60)));
            }

          if(answer == "00:00:00"){
              answer = "24:00:00";
          }

        System.out.println(answer);



        /*
        String firstArr[] = sc.next().split(":");
        String secondArr[] = sc.next().split(":");

        int firstHour = Integer.parseInt(firstArr[0]);
        int firstMin = Integer.parseInt(firstArr[1]);
        int firstSec = Integer.parseInt(firstArr[2]);

        int secondHour = Integer.parseInt(secondArr[0]);
        int secondMin = Integer.parseInt(secondArr[1]);
        int secondSec = Integer.parseInt(secondArr[2]);

        int firstAllSec = firstHour * 3600 + firstMin * 60 + firstSec;
        int secondAllSec = secondHour * 3600 + secondMin * 60 + secondSec;

        int allTime = secondAllSec - firstAllSec;
        if(allTime <= 0) { allTime += 24 * 3600;}
        int needHour = allTime/3600;
        int needMin = (allTime%3600)/60;
        int needSec = (allTime%3600)%60;

        String ans = "";
        if(needHour < 10 ) ans += "0" + needHour + ":";
        else ans += needHour + ":";
        if(needMin < 10 ) ans += "0" + needMin + ":";
        else ans += needMin + ":";
        if(needSec < 10 ) ans += "0" + needSec;
        else ans += needSec;

        System.out.println(ans);
*/

    }
}
