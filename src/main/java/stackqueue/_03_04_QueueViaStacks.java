package stackqueue;

import java.util.Stack;

class _03_04_QueueViaStacks {

    Stack<Integer> queuingStack = new Stack<>();
    Stack<Integer> dequeuingStack = new Stack<>();
    boolean hasDequeuOrPeeked = false;

    void enqueue(int val) {
        if(hasDequeuOrPeeked) {
            fillQueuingStack();
        }

        queuingStack.push(val);
        hasDequeuOrPeeked = false;
    }

    int size() {
        int size;

        if(hasDequeuOrPeeked) {
            size = dequeuingStack.size();
        } else {
            size = queuingStack.size();
        }
        return size;
    }

    int peek() {
        int peekVal;

        if(hasDequeuOrPeeked) {
            peekVal = dequeuingStack.pop();
        } else {
            fillDequeuingStack();
            peekVal = dequeuingStack.peek();
        }

        hasDequeuOrPeeked = true;
        return peekVal;
    }

    int dequeue() {
        if(!hasDequeuOrPeeked) {
            fillDequeuingStack();
        }

        int val = dequeuingStack.pop();

        hasDequeuOrPeeked = true;
        return val;
    }

    private void fillDequeuingStack() {
        while(!queuingStack.isEmpty()) {
            dequeuingStack.push(queuingStack.pop());
        }
    }

    private void fillQueuingStack() {
        while (!dequeuingStack.isEmpty()) {
            queuingStack.push(dequeuingStack.pop());
        }
    }
}
