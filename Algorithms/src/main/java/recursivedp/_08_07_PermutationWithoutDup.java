package recursivedp;

import java.util.ArrayList;
import java.util.Set;

/**
 * Write a method to compute all permutations of a string of unique characters.
 */
class _08_07_PermutationWithoutDup {

    public ArrayList<String> computePermutation(String str) {
        if(str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();

        if(str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        var first = str.charAt(0);
        var remainder = str.substring(1);

        ArrayList<String> words = computePermutation(remainder);

        for(String word : words) {
            for(int j = 0; j <= word.length(); j++) {
                String s = InsertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private String InsertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

}
