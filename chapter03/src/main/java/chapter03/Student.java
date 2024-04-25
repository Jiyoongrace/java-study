package chapter03;

public class Student extends Person {
    public Student() {
        // super(); 안 넣어도 자동으로 호출됨
        // 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면
        // 자동으로 부모의 기본 생성자 호출
        System.out.println("Student() called");
    }
}