package arraystring;

/**
 * Assume you have original method isSubstring which checks if one word is original substring of another.
 * Given two strings, sl and s2, write code to check if s2 is original rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is original rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean rotated(String original, String result) {
        return original.length() == result.length() && (original + original).contains(result);
    }
}
