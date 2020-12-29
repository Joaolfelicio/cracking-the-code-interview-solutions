package stackqueue;

import java.util.EmptyStackException;
import java.util.HashSet;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
class _03_02_MinStack {

    private int size = 0;
    private Node minHead;
    private Node[] stack = new Node[4];

    public void push(int val) {
        // If there is no more available space, increase the stack size
        if(size == stack.length) increaseStackSize();

        stack[size++] = createNewNode(val);
    }

    public int pop() {
        if(size == 0) throw new EmptyStackException();

        updateMinNode();

        return stack[--size].val;
     }

    public int min() {
        if(size == 0) throw new EmptyStackException();

        return minHead.val;
    }

    private void increaseStackSize() {
        Node[] newStack = new Node[stack.length * 2];

        for(int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    private Node createNewNode(int val) {
        // Create the new node
        Node newNode;
        if(minHead == null) {
            newNode = new Node(val);
            minHead = newNode;
        } else if(val > minHead.val) {
            newNode = new Node(val);
        } else {
            newNode = new Node(val, minHead);
            minHead = newNode;
        }
        return newNode;
    }

    private void updateMinNode() {
        if(stack[size - 1].val == minHead.val) {
            minHead = minHead.next;
        }
    }
}

class Node {

    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    };

    Node(int val) {
        this.val = val;
    }
}
