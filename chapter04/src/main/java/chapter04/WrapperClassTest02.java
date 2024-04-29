package chapter04;

public class WrapperClassTest02 {
    public static void main(String[] args) {

        // 2진수 or 16진수 -> 10진수
        String s = "123456";
        int i = Integer.parseInt(s);

        // cf1. 반대로
        String s1 = String.valueOf(i);

        // cf2. 반대로
        String s2 = "" + i;

        System.out.println(s + ":" + s1 + ":" + s2);

        int a = Character.getNumericValue('A');
        System.out.println(a); // 16진수 10

        // cf. ASCII 코드 값
        char c = 'A';
        System.out.println((int) c); // 아스키코드 65

        // 10진수 -> 2진수
        String s4 = Integer.toBinaryString(15);
        System.out.println(s4); // 1111

        // 10진수 -> 16진수
        String s5 = Integer.toHexString(15);
        System.out.println(s5);
    }
}
