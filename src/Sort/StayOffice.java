package Sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StayOffice {
    public String name ;

    public String status ;

    public StayOffice(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        StayOffice arr[] = new StayOffice[size];
        String arr1[] = new String[size];

        for(int i=0; i<size; i++){
            arr[i] = new StayOffice(sc.next(), sc.next());
        }

        Arrays.sort(arr, new Comparator<StayOffice>() {
            @Override
            public int compare(StayOffice o1, StayOffice o2) {
                return o2.name.compareTo(o1.name);
            }
        });


        for(int i=0; i<size-1; i ++){
            if(arr[i].status.equals("enter") && !arr[i].name.equals(arr[i+1].name)){
                System.out.println(arr[i].name);
            }

        }
        if(arr[size-1].status.equals("enter")){
            System.out.println(arr[size-1].name);
        }

    }

}
