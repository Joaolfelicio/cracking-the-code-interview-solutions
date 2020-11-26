package arraystring;

/**
 * Write a method to replace all spaces in a string with '%20'
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 *
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */

class _01_03_URLify {
    char[] urlify(char[] chars, int trueLength) {
        char[] escapeSpace = "%20".toCharArray();

        int endPointer = chars.length - 1;
        int startPointer = trueLength - 1;

        while(startPointer >= 0) {

            if(chars[startPointer] == ' ') {
                for(int k = escapeSpace.length - 1; k >= 0; k--) {

                    if(endPointer < startPointer || endPointer < 0) {
                        throw new IllegalArgumentException();
                    }

                    chars[endPointer] = escapeSpace[k];
                    endPointer--;
                }
            } else {
                chars[endPointer] = chars[startPointer];
                endPointer--;
            }
            startPointer--;
        }
        return chars;
    }
}
