package TwoPointer;

import java.io.*;

public class DNA {

    static int baseToIndex(char alp){
        if(alp == 'A') return 0;
        else if(alp == 'C') return 1;
        else if(alp == 'G') return 2;
        else if(alp == 'T') return 3;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 값
        String[] firstLine = br.readLine().split(" ");
        char[] sequence = br.readLine().toCharArray();
        String[] thirdLine = br.readLine().split(" ");

        int S = Integer.parseInt(firstLine[0]);
        int P = Integer.parseInt(firstLine[1]);

        int[] minimumCount = new int[4];
        for(int i=0; i< thirdLine.length; i++){
            minimumCount[i] = Integer.parseInt(thirdLine[i]);
        }

        int[] count = new int[4];
        for(int i=0; i<P-1; i++){
            count[baseToIndex(sequence[i])]++;
        }

        int ans = 0;
        for(int i= P-1; i<S; i++){
            count[baseToIndex(sequence[i])]++;
            if(isValid(count, minimumCount)){
                ans++;
            }
            count[baseToIndex(sequence[i - P +1])]--;

        }

        bw.write(ans + "");
        bw.flush();

    }

    static boolean isValid(int[] count, int[] minimumCount){
        for(int i=0; i<count.length;i++){
            if(count[i] < minimumCount[i]){
                return false;
            }
        }
        return true;
    }
}
