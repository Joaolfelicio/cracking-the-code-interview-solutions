package arraystring;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
        if(s.isEmpty()) return true;

        int[] charsQuantity = new int[26];
        int stringCharsLength = 0;

        for(int i = 0 ; i < s.length(); i++) {
            char currentChar = Character.toLowerCase(s.charAt(i));

            if(currentChar >= 'a' && currentChar <= 'z') {
                stringCharsLength++;
                int currentCharIndex = currentChar - 'a';
                charsQuantity[currentCharIndex]++;
            }
        }

        boolean hasFoundOdd = stringCharsLength % 2 == 0;

        for(int num : charsQuantity) {

            if (num % 2 == 1) {
                if (hasFoundOdd) {
                    return false;
                } else {
                    hasFoundOdd = true;
                }
            }
        }
        return true;
    }
}
