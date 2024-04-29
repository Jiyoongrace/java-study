package prob5;

public class MainApp03 {
    public static void main(String[] args) {
        try {
            MyStack03 stack = new MyStack03<>(5);
            stack.push("Hello");
            stack.push("World");
            stack.push("!!!");
            stack.push("java");
            // stack.push(1); // 실행 안됨
            stack.push(".");

            while (stack.isEmpty() == false) {
                String s = (String)stack.pop();
                System.out.println(s);
            }

            System.out.println("======================================");

            stack = new MyStack03<>(3);
            stack.push("Hello");

            System.out.println(stack.pop());
            System.out.println(stack.pop());

        } catch (MyStackException ex) {
            System.out.println(ex);
        }

    }
}
