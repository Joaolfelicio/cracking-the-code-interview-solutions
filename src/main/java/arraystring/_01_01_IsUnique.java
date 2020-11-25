package arraystring;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Page 90 - 1.1
 */

class _01_01_IsUnique {

    // With additional data structure
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    boolean isUnique(String str) {

        HashSet<Character> chars = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            if(chars.add(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

}
