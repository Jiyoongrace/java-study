package chapter04;

public class ObjectTest03 {
    public static void main(String[] args) {
        // String literal로 생성한 객체는 내용이 같다면 같은 객체, 즉 동일한 메모리 주소를 가리키고 있다.
        // 하지만 new 연산자로 생성한 String 객체는 내용이 같더라도 개별적인 객체임을 알 수 있다.
        String s1 = new String("hello");
        String s2 = new String("hello");

//        hashCode()는 오버라이딩이 가능하지만 identityHashCode()는 재정의가 불가능하다.
//        String 클래스의 hashcode는 value가 동일할 때 같다.
        // System 클래스에서 정의되는 identityHashCode()
        // String 클래스는 hashCode가 오버라이딩 되어 있으며
        // 객체가 달라도 hashCode() 값이 같게 나오도록 구현되어 있다.
        // 그러나 identityHashCode() 값은 다르게 출력된다.


        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println("hashCode(): " + s1.hashCode() + ":" + s2.hashCode()); // 서로 같음
//        System.out.println(s1.compareTo(s2));
        System.out.println("identityHashCode(): " + System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); // 서로 다름
        System.out.println("====================");

        String s3 = "hello"; // String literal
        String s4 = "hello"; // String은 new 연산자 말고 literal로 쓰기
        // JVM 메모리 구조(Heap 영역)에 의해 메모리 절약 가능(Constant Pool)
        // String 객체(new로 생성)는 Stack 영역에 저장
//        String literal로 생성하면 해당 String 값은 Heap 영역 내 "String Constant Pool"에 저장되어 재사용되지만,
//                new 연산자로 생성하면 같은 내용이라도 여러 개의 객체가 각각 Heap 영역을 차지하기 때문이다.


        System.out.println(s3 == s4); // true
        System.out.println(s3.equals(s4)); // true
        System.out.println("hashCode(): " + s3.hashCode() + ":" + s3.hashCode());
        System.out.println("identityHashCode(): " + System.identityHashCode(s3) + ":"  + System.identityHashCode(s4));

    }
}
