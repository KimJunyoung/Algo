package listpractice.arraylistprac;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyDouble {
    public static void main (String[] args) {
        List<Integer> list = new LinkedList<>();
        // 굳이 다형성을 사용할 필요가 없다면 아래와 같이 인스턴스를 만들어
        // LinkedList의 추가적인 메서드인 addFirst/Last 등을 사용할 수 있습니다.
        // LinkedList<Integer> list = new LinkedList<>();

        // LinkedList의 add: O(1)
        list.add(1);                // [1]
        list.add(2);                // [1, 2]
        list.add(3);                // [1, 2, 3]
        list.add(4);                // [1, 2, 3, 4]

        // LinkedList의 위치를 지정하는 add(insert): O(N)
        list.add(0, 5);             // [5, 1, 2, 3, 4]
        list.add(list.size(), 6);   // [5, 1, 2, 3, 4, 6]
        list.add(3, 7);             // [5, 1, 2, 7, 3, 4, 6]

        // LinkedList의 특정 위치값에 대한 set: O(N)
        list.set(2, -1);            // [5, 1, -1, 7, 3, 4, 6]
        System.out.println(list);

        // LinkedList의 특정 위치값에 대한 get: O(N)
        System.out.printf("index: %d, value: %d\n", 4, list.get(4));

        // LinkedList의 원소에 순차적으로 접근한다면 Iterator를 사용하는 것이 더 효율적입니다.
        // ListIterator는 내부적으로 next 노드를 가리키고 있어 이를 통해 앞/뒤로 이동할 수 있습니다.
        ListIterator<Integer> it = list.listIterator();
        // ListIterator 생성 시 아래와 같이 [0:list.size()] 범위에서 시작 위치를 지정할 수도 있습니다.
        // ListIterator<Integer> it = list.listIterator(3);

        // ListIterator를 3칸 뒤로 이동 후 상태를 확인하는 예제입니다.
        // 현재 Iterator: [^5, 1, -1, 7, 3, 4, 6]

        Integer fisrt = it.next();
        Integer second = it.next();
        Integer third = it.next();
        Integer four = it.next();
        Integer five = it.next();

        System.out.println("첫번째 " + fisrt);
        System.out.println("두번째 " + second);
        System.out.println("세번째 " + third);
        System.out.println("네번째 " + four);
        System.out.println("다섯번 " + five);

        System.out.println("돌아가기 " + it.previous());
        it.add(11);
        System.out.println("돌아가기 " + it.previous());



    }
}
