package stackqueue;

class _03_03_StackOfPlates {

    private NodeStack head;
    private int topElemIndex = -1;
    private int sizePerStack;

    _03_03_StackOfPlates(int threshold) {
        head = new NodeStack(new int[threshold]);
        sizePerStack = threshold;
    }

    void push(int val) {
        // If the stack is already at full size
        if(topElemIndex >= sizePerStack - 1) {
            NodeStack newStack = new NodeStack(new int[sizePerStack], head);
            head = newStack;
            topElemIndex = -1;
        }

        head.stack[++topElemIndex] = val;
    }

    int pop() {
        if(head.next == null && topElemIndex == -1) {
            throw new RuntimeException("Stack is empty");
        }

        int val = head.stack[topElemIndex--];

        if(head.next != null && topElemIndex == -1) {
            head = head.next;
            topElemIndex = sizePerStack - 1;
        }
        return val;
    }

    int popAt(int stackNum) {
        throw new UnsupportedOperationException();
    }

}

class NodeStack {
    int[] stack;
    NodeStack next;

    NodeStack(int[] stack, NodeStack next) {
        this.stack = stack;
        this.next = next;
    }

    NodeStack(int[] stack) {
        this.stack = stack;
    }
}
