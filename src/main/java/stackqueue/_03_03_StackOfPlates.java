package stackqueue;

class _03_03_StackOfPlates {

    private NodeStack head;
    private int sizePerStack;
    private int stackQuantity = 1;

    _03_03_StackOfPlates(int threshold) {
        head = new NodeStack(new int[threshold]);
        sizePerStack = threshold;
    }

    void push(int val) {

        // If the stack is already at full size, create a new stack
        if(head.headIndex == sizePerStack - 1) {
            createStack();
        }

        head.stack[++head.headIndex] = val;
    }

    int pop() {
        if(head.next == null && head.headIndex == -1) throw new RuntimeException("Stack is empty");

        int val = head.stack[head.headIndex--];

        // If the stack is empty, update head to the next node and reduce stack quantity
        if(head.next != null && head.headIndex == -1) {
            removeStack();
        }
        return val;
    }

    int popAt(int stackNum) {
        if(stackNum < 0 || stackNum > stackQuantity - 1) throw new RuntimeException("Invalid stack number");

        NodeStack currStack = head;
        NodeStack prevStack = null;

        // Get the stack with the stackNum
        for(int i = 0; i < stackQuantity - (stackNum + 1); i++) {
            prevStack = currStack;
            currStack = currStack.next;
        }

        int poppedVal = currStack.stack[currStack.headIndex--];

        // If the current stack is empty, update the pointers
        if(currStack.headIndex == -1) {
            if(prevStack == null) {
                head = head.next;
            } else if(currStack.next != null) {
                prevStack.next = currStack.next;
            } else {
                prevStack.next = null;
            }
            stackQuantity--;
        }

        return poppedVal;

    }

    private void removeStack() {
        head = head.next;
        stackQuantity--;
    }

    private void createStack() {
        NodeStack newStack = new NodeStack(new int[sizePerStack], head);
        head = newStack;
        stackQuantity++;
    }
}

class NodeStack {
    int[] stack;
    NodeStack next;
    int headIndex = -1;

    NodeStack(int[] stack, NodeStack next) {
        this.stack = stack;
        this.next = next;
    }

    NodeStack(int[] stack) {
        this.stack = stack;
    }
}
