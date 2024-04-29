package creational.singleton;

public class Client {
    public static void main(String[] args) {
        // private 생성자이므로 new를 통해 인스턴스 생성할 수 없음
        // Singleton s1 = new Singleton();

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

//        creational.singleton.Singleton@3b07d329
//        creational.singleton.Singleton@3b07d329
//        creational.singleton.Singleton@3b07d329
    }
}
