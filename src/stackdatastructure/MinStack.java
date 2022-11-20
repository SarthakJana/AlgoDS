package stackdatastructure;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minimumStack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if (minimumStack.isEmpty() || minimumStack.peek() > val) {
            stack.push(val);
            minimumStack.push(val);
        } else {
            stack.push(val);
        }
    }

    public int pop() {

        if (stack.isEmpty()) {
            return -1;
        }

        if (minimumStack.peek() == stack.peek()) {
            minimumStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMinimumValue() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return minimumStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(18);
        minStack.push(19);
        minStack.push(29);
        minStack.push(15);
        minStack.push(30);
        minStack.push(11);
        minStack.pop();
        System.out.println(minStack.getMinimumValue());
        System.out.println(minStack.pop());
    }
}
