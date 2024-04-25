package prob5;

public class MyStack {
    private int top = -1;
    private int capacity;
    private String[] array;

    public MyStack(int capacity) {
        this.capacity = capacity;
        array = new String[capacity];
        top = -1;
    }

    public void push(String item) throws MyStackException {
        if(top == capacity - 1) {
            throw new MyStackException("Stack is full!");
        }
        top++;
        array[top] = item;
    }

    public String pop() throws MyStackException {
        if (isEmpty()) {
            throw new MyStackException("Stack is empty!");
        }
        String item = array[top];
        top--;
        return item;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public class MyStackException extends Exception {
        public MyStackException(String message) {
            super(message);
        }
    }
}