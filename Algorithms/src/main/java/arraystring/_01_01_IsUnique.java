package arraystring;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Page 90 - 1.1
 */

class _01_01_IsUnique {

    // Using HashSet
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    boolean isUniqueHashSet(String str) {

        HashSet<Character> chars = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            if(chars.add(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    // Brute Forcing
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    boolean isUniqueBruteForce(String str) {

        for(int i = 0; i < str.length(); i++) {
            for(int k = 0; k < str.length(); k++) {
                if(str.charAt(i) == str.charAt(k) && i != k) {
                    return false;
                }
            }
        }
        return true;
    }

    // With bool array
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    boolean isUniqueBoolArr(String str) {
        if(str.length() > 128) {
            return false;
        }

        boolean[] boolArr = new boolean[128];

        for(int i = 0; i < str.length(); i++) {
            if(boolArr[str.charAt(i)]) {
                return false;
            }
            boolArr[str.charAt(i)] = true;
        }
        return true;
    }

    // With bit vector
    // Time Complexity: O(n)
    // Space Complexity: O(1) - Space complexity is reduced by a factor of 8 compared to using a bool array
    boolean isUniqueBitVector(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
