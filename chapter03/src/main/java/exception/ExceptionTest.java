package exception;

public class ExceptionTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10 - a;

        System.out.println(" Some Code1...");

        try { // 예외가 발생할 가능성이 있는 실행문
            System.out.println(" Some Code2...");
            System.out.println(" Some Code3...");

            int result = (1 + 2 + 3) / b;

            System.out.println(" Some Code4...");
            System.out.println(" Some Code5...");

        } catch (ArithmeticException e) { // 처리할 예외 타입 선언
            /* 예외 처리 */
            /* 예외 발생 시에만 실행 */
            /* 비워두면 안됨 */
            // e.printStackTrace();
            // 1. 로깅
            System.out.println("error: " + e);

            // 2. 사과
            System.out.println("미안합니다^^");

            // 3. 정상 종료
            // System.exit(0);
            return;
        } finally {
            // 자원 정리는 맨 아래에 하는 것이 일반적이다.
            // 예외 발생 여부와 상관없이 무조건 실행되는 문장 (생략 가능)
            System.out.println("자원 정리: ex) close file, socket, db connection");
        }

        // try-catch 아래에는 코드를 적지 않는 것이 좋다.
        System.out.println(" Some Code6...");
        System.out.println(" Some Code7...");

    }
}
