package bitmanipulation;

/**
 * Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR:'
 */
class _05_02_BinaryToString {
    String print(double num) {
        if(num == 0) return "ERROR";

        StringBuilder result = new StringBuilder(".");

        while(num > 0) {
            if(result.length() >= 32) return "ERROR";

            num *= 2;

            if(num >= 1) {
                result.append("1");
                num -= 1;
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }
}