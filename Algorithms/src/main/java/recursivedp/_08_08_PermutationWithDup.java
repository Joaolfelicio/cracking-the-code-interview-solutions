package recursivedp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Write a method to compute all permutations of a string whose characters
 * are not necessarily unique. The list of permutations should not have duplicates.
 */
class _08_08_PermutationWithDup {

    public ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    private HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if(remaining == 0) {
            result.add(prefix);
            return;
        }

        for(Character c : map.keySet()) {
            int count = map.get(c);
            if(count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

}
