package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoopTreePrac {

    static int N;
    static ArrayList<Integer>[] chr;
    static ArrayList<Character> leftAns;
    static ArrayList<Character> midAns;
    static ArrayList<Character> rightAns;
    static Node root;
    static Node[] nodes;

    static class Node{
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void insertLeft(Node left){
            this.left = left;
        }
        public void insertRight(Node right){
            this.right = right;
        }
    }

    public static void leftDfs(Node x){

        if(x.left != null) leftDfs(x.left);
        leftAns.add((char) ('A' +x.val));
        if(x.right != null)  leftDfs(x.right);
    }
    public static void pro(){
        leftDfs(root);
    }

    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chr = new ArrayList[N];
        nodes = new Node[N];

        leftAns = new ArrayList<>();

        for(int i=0; i<N; i++){
            chr[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            nodes[i] = new Node(i);
        }

        root = nodes[0];

        for(int i=0; i<N; i++){
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            char c = sc.next().charAt(0);

            int bINt = b - 'A';
            int cINt = c - 'A';
             // . -> -19
            if(bINt != -19) nodes[a - 'A'].insertLeft(nodes[bINt]);
            if(cINt != -19) nodes[a - 'A'].insertRight(nodes[cINt]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        input();
        pro();
        for (Character leftAn : leftAns) {
            System.out.print(leftAn);
        }
    }
}
