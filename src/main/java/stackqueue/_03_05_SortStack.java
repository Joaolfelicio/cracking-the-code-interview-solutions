package stackqueue;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
class  _03_05_SortStack {

    Stack<Integer> sort(Stack<Integer> descendingStack) {
        Stack<Integer> ascendingStack = new Stack<>();

        int counter = 0;

        while(counter != descendingStack.size()) {

            counter = 0;

            while(!descendingStack.isEmpty()){
                int valToCompare = descendingStack.pop();

                if (descendingStack.isEmpty() || valToCompare >= descendingStack.peek()) {
                    ascendingStack.push(valToCompare);
                    counter++;
                } else {
                    ascendingStack.push(descendingStack.pop());
                    descendingStack.push(valToCompare);
                }
            }

            // If the counter is equal to the ascendingStack size, means we haven't made any change, so it's already sorted
            if(counter == ascendingStack.size()) break;

            while(!ascendingStack.isEmpty()){
                int valToCompare = ascendingStack.pop();

                if (ascendingStack.isEmpty() || valToCompare <= ascendingStack.peek() ) {
                    descendingStack.push(valToCompare);
                } else {
                    descendingStack.push(ascendingStack.pop());
                    ascendingStack.push(valToCompare);
                }
            }
        }
        return ascendingStack;
    }
}
