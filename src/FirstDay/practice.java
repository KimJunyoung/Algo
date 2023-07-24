package FirstDay;


import java.util.*;
import java.util.stream.Stream;


public class practice {
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<String>(Arrays.asList("Java", "C++", "Python", "Scala", "Go"));

       Optional<String> ele = arr.stream().findAny(); // Optional[Java]
        System.out.println(ele.get());
    }
}