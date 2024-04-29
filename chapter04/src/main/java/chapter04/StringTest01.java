package chapter04;

public class StringTest01 {
    public static void main(String[] args) {
        // c:\temp
        System.out.println("c:\\temp"); // 역슬래시 \ 이것은 잘못 읽힐 수 있다. (c:\temp 출력 -> c:  temp)

        // "Hello" (쌍따옴표 포함 출력)
        System.out.println("\"hello\""); // 이스케이프 시퀀스

        // \t: tab
        // \r: carriage return
        // \n: newline
        // \b: beep
        System.out.print("hello\tworld\n");
        System.out.println("hello\tworld");

        // '
        char c = '\'';
        System.out.println(c);
    }
}
