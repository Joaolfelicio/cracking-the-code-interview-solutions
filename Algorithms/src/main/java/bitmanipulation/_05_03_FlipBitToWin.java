package bitmanipulation;

/**
 * You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create.
 * <p>
 * EXAMPLE
 * Input: 1775 (or: 11011101111)
 * Output: 8
 */
class _05_03_FlipBitToWin {
    int flip(int n) {
        if(~n == 0) return Integer.BYTES * 8;

        int counter = 0;
        int prevCounter = 0;
        int highestSubsequence = 1;

        while(n > 0)
        {
            if((1 & n) == 1) {
                counter++;
            } else {
                prevCounter = (n & 2) == 0 ? 0 : counter;
                counter = 0;
            }
            n >>>= 1;
            highestSubsequence = Math.max(counter + prevCounter + 1, highestSubsequence);
        }
        return highestSubsequence;
    }
}
