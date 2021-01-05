package recursivedp;

/**
 * Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
class _08_05_RecursiveMultiply {

    int multiple(int a, int b) {
        int lowest = Math.min(a, b);
        int highest = Math.max(a, b);
        int total = 0;

        while(lowest > 0) {
            total += highest;
            lowest--;
        }
        return total;
    }
}
