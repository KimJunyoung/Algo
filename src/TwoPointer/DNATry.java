package TwoPointer;

import java.io.*;

public class DNATry {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 값
        String[] firstLine = br.readLine().split(" ");
        char[] charArray = br.readLine().toCharArray();
        String[] thirdLine = br.readLine().split(" ");

        int S = Integer.parseInt(firstLine[0]);
        int P = Integer.parseInt(firstLine[1]);

        int A = Integer.parseInt(thirdLine[0]);
        int C = Integer.parseInt(thirdLine[1]);
        int G = Integer.parseInt(thirdLine[2]);
        int T = Integer.parseInt(thirdLine[3]);

        int rightIndex = 0;
        int ansCount = 0;
        int[] charCheck = new int[25];

        // 투포인터 돌려보자
        for(int i=0; i<charArray.length; i++){
            int count = 1;
            rightIndex = i ;

            while(count <= P && rightIndex < S){
                charCheck[charArray[rightIndex++] - 'A']++;
                count++;
            }

            if(charCheck[0] >= A && charCheck['C'-'A'] >= C && charCheck['G'-'A'] >= G
            && charCheck['T'-'A'] >= T){
                ansCount ++;
            }

            charCheck[charArray[i] -'A'] --;

            if(rightIndex == S){
                break;
            }


        }

        bw.write(ansCount + "");
        bw.flush();




    }
}
