package chapter04;

public class ObjectTest02 {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        Point p3 = p2;

        // == : 두 객체의 동일성(Identity)
        System.out.println(p1 == p2); // false
        System.out.println(p2 == p3); // true

        // equals : 두 객체의 동등성(Equality), 내용 비교
        //          부모 클래스 Object의 기본 구현은 동일성(==) 비교와 같다.
        // 동일성에서 동등성 비교로 바꾸려면 오버라이드 필수
        System.out.println(p1.equals(p2)); // false
        System.out.println(p2.equals(p3)); // true
    }
}
