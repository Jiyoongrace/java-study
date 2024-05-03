package test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        try {
            String originalInput = "안녕하세요";
            System.out.println("original: " + originalInput);

            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes("utf-8"));
            System.out.println("Encoded: " + encodedString);

            String decodedString = new String(Base64.getDecoder().decode(encodedString), "utf-8");
            System.out.println("decoded: " + decodedString);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}