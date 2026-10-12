public class Stack {

    private int[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow. Stack is full.");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println("Value pushed successfully.");
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow. Stack is empty.");
            return;
        }

        int value = stack[top];
        top--;

        System.out.println("Popped value: " + value);
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top value: " + stack[top]);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }
}