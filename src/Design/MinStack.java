package Design;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    private PriorityQueue<Integer> heap;
    private Stack<Integer> stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.heap = new PriorityQueue<>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        heap.add(x);
        stack.push(x);
        stack.push(x);
    }

    public void pop() {
        int cur = stack.pop();
        heap.remove(cur);
    }

    public int top() {
        return stack.peek();
    }

    // do not pop the heap, only peek!
    public int getMin() {
        return heap.peek();
    }
}
