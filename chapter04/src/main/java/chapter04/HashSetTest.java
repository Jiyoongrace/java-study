package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Rect> set = new HashSet<Rect>();

        Rect r1 = new Rect(10, 20);
        Rect r2 = new Rect(10, 20);
        Rect r3 = new Rect(4, 50);

        set.add(r1);
        set.add(r2);
        set.add(r3);

        for(Rect r : set) {
            System.out.println(r);
        }
        // equals() & hashCode() -> 오버라이딩하기 전
//        chapter04.Rect@41629346
//        chapter04.Rect@3b07d329
        // equals() & hashCode() -> 오버라이딩한 후
//        Rect(w=10, h=20)
    }
}
