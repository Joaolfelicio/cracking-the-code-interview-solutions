package arraystring;

import java.util.HashMap;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    boolean checkPermutationWithHashMap(String a, String b) {
        if(a.length() != b.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < a.length(); i++) {
            char currentChar = a.charAt(i);

            if(map.containsKey(currentChar)) {
                map.replace(currentChar, map.get(currentChar) + 1) ;
            } else {
                map.put(currentChar, 1);
            }
        }

        for(int i = 0; i < b.length(); i++) {
            char currentChar = b.charAt(i);

            if(map.containsKey(currentChar)) {
                int quantityChar = map.get(currentChar) - 1;

                if(quantityChar == 0) {
                    map.remove(currentChar);
                } else {
                    map.replace(currentChar, quantityChar);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    boolean checkPermutationWithArray(String a, String b) {
        if(a.length() != b.length()) return false;

        int[] matrix = new int[128];

        for(int i = 0; i < a.length(); i++) {
            matrix[a.charAt(i)]++;
        }

        for(int i = 0; i < b.length(); i++) {
            matrix[b.charAt(i)]--;

            if(matrix[b.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
