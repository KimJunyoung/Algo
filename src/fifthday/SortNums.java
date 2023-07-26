package fifthday;

import java.io.*;



public class SortNums {

    public static void main(String[] args) throws IOException {


        /*
        int countArray[] = new int[10001];
        for(int i=0; i<size;i++){
            countArray[Integer.parseInt(br.readLine())]++;
        }
        for(int i=1; i<=10000; i++){
            while(countArray[i]-- > 0){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        */

        /*
        for(int i=0;i<size;i++){

            for(int j=0; j<i; j++){
                if(array[j] > array[i]){
                    int point = array[i];
                    for(int k=i; k>j; k--){
                        array[k] = array[k-1];
                    }
                    array[j] = point;
                    break;
                }
            }
        }

        for(int i=0; i<size; i++){
            System.out.println(array[i]);
        }
*/
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            cnt[n]++;
        }

        for (int i = 1; i <= 10000; i++)
            while(cnt[i]-- > 0) {
                bw.write(i + "\n");
            }
        bw.flush();

    }
}
