package bitmanipulation;

/**
 * Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 * <p>
 * EXAMPLE
 * Input: 29 (or: 11101), 15 (or: 01111)
 * Output: 2
 */
public class _05_06_Conversion {
    int convert(int a, int b) {

        int result = a ^ b;

        int count = 0;

        while(result != 0) {
            count += 1 & result;

            result >>= 1;
        }

        return count;
    }
}
