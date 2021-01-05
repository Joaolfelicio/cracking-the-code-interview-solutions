package recursivedp;

/**
 * Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
class _08_05_RecursiveMultiply {

    int multiple(int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int halfValue = smaller >> 1;
        int halfProd = minProductHelper(halfValue, bigger);

        if(smaller % 2 == 0) return halfProd + halfProd;

        return halfProd + halfProd + bigger;
    }
}
