package fifthday;

import java.io.*;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int P = Integer.parseInt(br.readLine());

        for(int i=0; i<P; i++){
            String[] s = br.readLine().split(" ");

            switch (s[0]){
                case "push" : stack.push(Integer.parseInt(s[1]));
                break;
                case "pop" :
                    if(stack.size() == 0) {
                        bw.write("-1" + "\n");
                    } else{
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    if(stack.empty()){
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;
                case "top" :
                    if (stack.empty()){
                        bw.write("-1" + "\n");
                    }else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();

    }

}
