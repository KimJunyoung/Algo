package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {

    static int N;
    static ArrayList<Integer>[] arrList;
    static ArrayList<Integer> input;
    static ArrayList<Integer> ans;

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.val) {
                if(this.left == null){
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else{
                if(this.right == null){
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }


    public static void input() throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        input = new ArrayList<>();
        ans = new ArrayList<>();
        try{
            for(int i=0; i<10010; i++){
              input.add(sc.nextInt());
            }
        }catch (Exception e){
                N = input.size();
        }

    }

    public static void pro(){
        Node root = new Node(input.get(0));
        for(int i=1; i<N; i++){
            root.insert(input.get(i));
        }

        postOrder(root);
    }

    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        ans.add(node.val);
    }

    public static void main(String[] args) throws FileNotFoundException {
            input();
            pro();
        for (Integer an : ans) {
            System.out.println(an);
        }
}

}
