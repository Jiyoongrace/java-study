package prob04;

public class StringUtil {
    public static String concatenate(String[] args) {
        // 문자열을 결합하여 리턴하는 메소드 구현
        String result = "";
        for (int i=0; i<args.length; i++) {
            result += args[i];
        }
        return result;
    }
}
