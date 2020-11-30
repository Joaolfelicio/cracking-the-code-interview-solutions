package arraystring;

/**
 * Assume you have original method isSubstring which checks if one word is original substring of another.
 * Given two strings, sl and s2, write code to check if s2 is original rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is original rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean rotated(String original, String result) {
        if(original.length() != result.length()) return false;

        int origPointer = 0;
        int resultPointer = 0;
        int length = 0;
        boolean hasRotated = false;

        while((origPointer != 0 || !hasRotated) && origPointer < original.length()) {
            if(original.charAt(origPointer) == result.charAt(resultPointer)) {

                origPointer++;
                length++;
            } else {

                if(origPointer != 0) {
                    resultPointer -= length;
                    origPointer = 0 ;
                }

                length = 0;
            }

            if(resultPointer == original.length() - 1) {
                if(origPointer == 0) return false;
                resultPointer = 0;
                hasRotated = true;
            } else {
                resultPointer++;
            }

        }

        return length == original.length();
    }

}
