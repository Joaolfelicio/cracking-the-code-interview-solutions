package stackqueue;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
class  _03_05_SortStack {

    Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while(!stack.isEmpty()){
            int valToCompare = stack.pop();

            if (!tempStack.isEmpty() && valToCompare > tempStack.peek()) {
                while (!tempStack.isEmpty() && valToCompare >= tempStack.peek()) stack.push(tempStack.pop());
            }
            tempStack.push(valToCompare);
        }
        return tempStack;
    }
}
