package Exception;

import java.io.IOException;

public class MyClassTest {
    public static void main(String[] args) {
        try {
            new MyClass().danger(); // 컴파일 오류 발생
        } catch (IOException e) {
            // System.out.println("error: " + e);
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println("error: " + e);
        }
    }
}
