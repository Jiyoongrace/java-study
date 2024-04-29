package prob01;

import java.awt.*;
import java.util.ArrayList;

public class Printer {
    private int num;
    private boolean check;
    private double fnum;
    private String name;

//    public void println(int num) {
//        System.out.println(num);
//    }
//
//    public void println(boolean check) {
//        System.out.println(check);
//    }
//
//    public void println(double fnum) {
//        System.out.println(fnum);
//    }
//
//    public void println(String name) {
//        System.out.println(name);
//    }
    public <T> void println(T t) {
        System.out.println(t);
    }

    public <T> void println(T... ts) {
        for(T t : ts) {
            System.out.println(t);
        }
    }

    public int sum(Integer... nums) {
        int s = 0;
        for(Integer n : nums) {
            s += n;
        }

        return s;
    }

//    public <T, S> S println(T t, S s) {
//        System.out.println(t);
//        return s;
//    }
    // int i = println("hello", 1)


//    <T extends Shape>
//    <T super Shape>
//    <? extends Shape>
//    <? super Shape>
//    <? extends T> // T 타입의 상위 범위
//    <? super T>     // T 타입의 하위 범위
//    MyStack03<T extends Shape>
//
//    void m(List<Shape> s) {
//
//    }
//    List<Circle> l = new ArrayList<>();
//    m(l); // 오류 -> 와일드카드로 해결
}
