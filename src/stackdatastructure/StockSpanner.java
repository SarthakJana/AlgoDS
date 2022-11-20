package stackdatastructure;

import kotlin.Pair;

import java.util.Stack;

public class StockSpanner {
    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    int index = -1;

    public StockSpanner() {

    }

    public int next(int price) {
        index = index + 1;
        int span;
        Pair<Integer, Integer> pair = new Pair(index, price);
        while (!stack.isEmpty() && stack.peek().getSecond() <= price) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            stack.push(pair);
            return 1;
        } else {
            span = index - stack.peek().getFirst();
            stack.push(pair);
        }

        return span;
    }
}
