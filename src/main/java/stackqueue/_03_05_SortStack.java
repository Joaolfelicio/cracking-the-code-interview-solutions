package stackqueue;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
class  _03_05_SortStack {

    Stack<Integer> sort(Stack<Integer> hiValuesOnTopStack) {
        Stack<Integer> loValuesOnTopStack = new Stack<>();

        int counter = 0;

        while(counter != hiValuesOnTopStack.size()) {

            // Kee
            counter = 0;

            while(!hiValuesOnTopStack.isEmpty()){
                int valToCompare = hiValuesOnTopStack.pop();

                if (hiValuesOnTopStack.isEmpty() || valToCompare >= hiValuesOnTopStack.peek()) {
                    loValuesOnTopStack.push(valToCompare);
                    counter++;
                } else {
                    loValuesOnTopStack.push(hiValuesOnTopStack.pop());
                    hiValuesOnTopStack.push(valToCompare);
                }
            }

            if(counter == loValuesOnTopStack.size()) break;

            while(!loValuesOnTopStack.isEmpty()){
                int valToCompare = loValuesOnTopStack.pop();

                if (loValuesOnTopStack.isEmpty() || valToCompare <= loValuesOnTopStack.peek() ) {
                    hiValuesOnTopStack.push(valToCompare);
                } else {
                    hiValuesOnTopStack.push(loValuesOnTopStack.pop());
                    loValuesOnTopStack.push(valToCompare);
                }
            }
        }
        return loValuesOnTopStack;
    }
}
