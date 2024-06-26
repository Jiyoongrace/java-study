package creational.singleton;

public class Singleton {
    private static Singleton instance = null; // 정적 참조 변수

    private Singleton() {}; // private 생성자

    // 객체 반환 정적 메서드
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
