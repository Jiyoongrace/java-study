package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        BufferedOutputStream bos = null;

        try {
            // 기반 스트림(주 스트림)
            FileOutputStream fos = new FileOutputStream("hello.txt");

            // 보조 스트림(데코레이터 패턴과 함께 이해하기)
            bos = new BufferedOutputStream(fos);

            // for(int i = 'a'; i<= 'z'; i++)
            for(int i = 97; i<= 122; i++) { // char를 int로 형변환
                bos.write(i);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + e);
        } catch (IOException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if(bos != null) {
                    bos.close();
                }
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
