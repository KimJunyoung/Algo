import java.io.*;
import java.util.*;

public class Main {
    private Integer age ;
    private String name;

    Main(int a, String n){
        age = a;
        name = n;
    }
    public static void main(String[] args) throws FileNotFoundException {


        Main a = new Main(10, "kim");
        Main b = new Main(11, "kim");

        System.out.println(a.name == b.name);

    }
    }
