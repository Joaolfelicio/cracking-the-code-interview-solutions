package bitmanipulation;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
 * <p>
 * EXAMPLE
 * Input: N   10000000000, M 10011, i 2, j 6
 * Output:N = 10001001100
 */
class _05_01_Insertion {

    int insert(int n, int m, int i, int j) {

        // Get all ones
        int allOnes = ~0;

        // Create mask with 1s before j position
        int left = j < 32 ? (allOnes << j + 1) : 0;

        // Create mask with 1s after i position
        int right = (1 << i) - 1;

        // Create mask containing both left and right
        int mask = left | right;

        // AND both to get a clean index where M should go
        int cleanN = mask & n;

        // Shift M into the correct position
        int shiftedM = m << i;

        // Put them together
        return shiftedM | cleanN;
    }
}
