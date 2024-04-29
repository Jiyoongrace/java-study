package chapter04;

public class StringTest03 {
    public static void main(String[] args) {
        // String s1 = "Hello " + "World " + "java" + 17;

//        String s1 = new StringBuilder("Hello ")
//                .append("World ")
//                .append("java")
//                .append(17)
//                .toString();

        // StringBuffer VS StringBuilder 차이점
        // 주로 StringBuffer 사용
        // StringBuffer는 동기화 지원 -> 멀티 스레드 환경에서도 안전하게 동작
        // synchronized -> 여러 개의 스레드가 한 개의 자원에 접근하려고 할 때,
        // 현재 데이터를 사용하고 있는 스레드를 제외하고
        // 나머지 스레드들이 데이터에 접근할 수 없도록 막는 역할을 수행한다.
        String s1 = new StringBuffer("Hello ")
                .append("World ")
                .append("java")
                .append(17)
                .toString();

        // System.out.println(s1);

//        String s2 = "";
//        for (int i=0; i<1000000; i++) {
//            // s2 = s2 + "h";
//            // s2 = new StringBuffer(s2).append("h").toString();
//        }

        StringBuffer sb = new StringBuffer("");
        for (int i=0; i<1000000; i++) {
            sb.append("h");
        }
        String s3 = sb.toString();

        // 1. String을 사용해야 할 때
        // 변하지 않는 문자열을 자주 사용할 경우 성능 면에서 유리

        // 2. StringBuilder를 사용해야 할 때
        // StringBuilder는 동기화를 지원하지 않는 반면,
        // StringBuffer보다 성능이 좋다.
        // 따라서 단일 스레드 환경과 문자열의 추가, 수정, 삭제 등이
        // 빈번히 발생하면 StringBuilder를 사용하는 것이 성능 면에서 유리

        // 3. StringBuffer를 사용해야 할 때
        // StringBuffer는 동기화를 지원하여 멀티 스레드 환경에서도 안전하게 동작한다.
        // 따라서 멀티 스레드 환경과 문자열의 추가, 수정, 삭제 등이
        // 빈번히 발생하면 StringBuffer를 사용하는 것이 성능 면에서 유리

        // String method
        String s4 = "aBcABCabcAbc";
        System.out.println(s4.length());
        System.out.println(s4.charAt(2));
        System.out.println(s4.indexOf("abc"));
        System.out.println(s4.indexOf("abc", 7)); // 7번째부터 찾기(없으면 -1)
        System.out.println(s4.substring(3));
        System.out.println(s4.substring(3, 5));

        String s5 = "    ab     cd    ";
        String s6 = "efg,hij,klm,nop,qrs";

        String s7 = s5.concat(s6); // 문자열 합치기
        System.out.println(s7);

        System.out.println("----" + s5.trim() + "----"); // space 없어짐, 안쪽 공백은 그대로
        System.out.println("----" + s5.replaceAll(" ", "") + "----");

        String[] tokens = s6.split(",");
        for (String s : tokens) {
            System.out.println(s);
        }

        String[] tokens2 = s6.split(" ");
        for (String s : tokens2) {
            System.out.println(s);
        }
    }
}
