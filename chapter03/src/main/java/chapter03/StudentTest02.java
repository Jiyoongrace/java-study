package chapter03;

public class StudentTest02 {
    public static void main(String[] args) {
        Student s1 = new Student();

        Person p1 = s1; // upcasting(암시적, Implicity), 자식 -> 부모
        Student s2 = (Student)p1; // downcasting(명시적, Explicity), 부모 -> 자식
    }
}
