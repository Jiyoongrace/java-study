package prob5;

import java.lang.reflect.Array;

// Object보다는 generic을 더 선호한다.
// 컴파일 시 타입캐스팅
// <T>, <E>
// <K>, <V>
// <S>, <U>
// MyStack<String> stack = new MyStack<>(); // Java 17부터 <> 생략 가능
// MyStack<String> stack = new MyStack<>(String.class, 3);
public class MyStack03<T> {
    private int top;
    private T[] buffer;

    //컴파일 경고를 사용하지 않도록 설정해주는 것으로
    // 한마디로 IDE에서 노란색 표시줄이 나타내는 것 즉, 경고를 제외시킬 때 사용한다.
    @SuppressWarnings("unchecked") // 미확인 오퍼레이션과 관련된 경고를 억제한다.
//    public MyStack03(Class<?> klass, int capacity) {
    public MyStack03(int capacity) {
        top = -1;
        buffer = (T[])new String[capacity]; // 좋은 방식
        // buffer = (T[]) Array.newInstance(klass, capacity); // 참고용
    }

    public void push(T s) {
        if (top == buffer.length - 1) {
            resize();
        }

        buffer[++top] = s;
    }

    public T pop() throws MyStackException {
        if (isEmpty()) {
            throw new MyStackException("stack is empty");
        }

        T result = buffer[top];
        buffer[top--] = null;

        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] temp = (T[])new Object[buffer.length * 2];
        for (int i = 0; i <= top; i++) {
            temp[i] = buffer[i];
        }

        buffer = temp;
    }
}