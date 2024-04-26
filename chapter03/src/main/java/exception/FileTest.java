package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("hello.txt");
            int data = fis.read();
            System.out.println((char)data);
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            System.out.println("error: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // io, network, jdbc, thread에서 Checked Exception 자주 발생
        // Checked Exception -> Runtime Exception
        // Checked Exception 반드시 예외를 체크하는 코드
        // try-catch 구문 필수
        // compile 안됨
    }
}
