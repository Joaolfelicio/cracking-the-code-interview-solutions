package stackqueue;

import java.util.Stack;

class _03_04_QueueViaStacks {

    Stack<Integer> stackNewOnTop = new Stack<>();
    Stack<Integer> stackOldOnTop = new Stack<>();

    void enqueue(int val) {
        stackNewOnTop.push(val);
    }

    int size() {
        return stackNewOnTop.size() + stackOldOnTop.size();
    }

    int peek() {
        shiftStacks();
        return stackOldOnTop.peek();
    }

    int dequeue() {
        shiftStacks();
        return stackOldOnTop.pop();
    }

    private void shiftStacks() {
        if(stackOldOnTop.isEmpty()) {
            while(!stackNewOnTop.isEmpty()) {
                stackOldOnTop.push(stackNewOnTop.pop());
            }
        }
    }
}
