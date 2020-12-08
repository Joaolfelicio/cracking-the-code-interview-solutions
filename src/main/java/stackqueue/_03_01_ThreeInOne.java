package stackqueue;

/**
 * Describe how you could use a single array to implement three stacks
 */
class _03_01_ThreeInOne {

    int sizePerStack;
    int[] tripleStack;
    int[] stackTails;
    int stackQuantity = 3;


    _03_01_ThreeInOne(int initSize) {
        tripleStack = new int[initSize * stackQuantity];
        stackTails = new int[stackQuantity];
        sizePerStack = initSize;
    }

    void push(int stackNum, int val) throws Exception {

        if(stackNum >= 0 && stackNum < stackQuantity) {
            pushToStack(stackNum, val);
        } else {
            throw new RuntimeException("Invalid stack number");
        }
    }

    private void pushToStack(int stackNum, int val) throws Exception {
        if(stackTails[stackNum] == sizePerStack) throw new RuntimeException("Stack " + stackNum + " is already full");

        int newTail = sizePerStack * stackNum + stackTails[stackNum];

        tripleStack[newTail] = val;

        stackTails[stackNum]++;
    }

    int pop(int stackNum) throws Exception {
        if(stackNum >= 0 && stackNum < stackQuantity) {
            return popFromStack(stackNum);
        } else {
            throw new RuntimeException("Invalid stack number");
        }
    }

    private int popFromStack(int stackNum) throws Exception {
        if(stackTails[stackNum] == 0) throw new RuntimeException("Stack " + stackNum + " is empty");

        int indexValue = sizePerStack * stackNum + stackTails[stackNum];

        stackTails[stackNum]--;

        return tripleStack[indexValue - 1];
    }
}
