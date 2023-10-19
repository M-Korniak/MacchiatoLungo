package stack;

public class Stack {
    private final int[] stack;
    private int top;

    public Stack() {
        stack = new int[10];
        top = -1;
    }

    public void push(int x) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return 0;
        }
        return stack[top--];
    }
    public int peekDeeper(int howDeep) {
        if (top - howDeep <= -1) {
            return 0;
        }
        return stack[top - howDeep];
    }
    public int peek() {
        if (top == -1) {
            return 0;
        }
        return stack[top];
    }
    public int size() {
        return top + 1;
    }
    public boolean empty() {
        return top == -1;
    }
    private void resize() {
        System.arraycopy(stack, 0, stack, 0, stack.length * 2);
    }
}
