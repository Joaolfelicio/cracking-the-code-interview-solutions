package arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale,  ple   -> true
 * pales, pale  -> true
 * pale,  bale  -> true
 * pale,  bake  -> false
 * pae,   pale  -> true
 * paxye, paxe -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {

        String bigStr = a.length() > b.length() ? a : b;
        String smallStr = a.length() > b.length() ? b : a;

        if(a.length() + 1 < b.length() || b.length() + 1 < a.length()) return false;

        int numOfChanges = 0;
        int bigArrPointer = bigStr.length() - 1;
        int smallArrPointer = smallStr.length() - 1;

        // Change
        if(a.length() == b.length()) {
            while(bigArrPointer >= 0) {
                if(bigStr.charAt(bigArrPointer) != smallStr.charAt(bigArrPointer)) {
                    numOfChanges++;
                }
                bigArrPointer--;
            }

        // Remove and Add
        } else {
            while(bigArrPointer >= 0 && smallArrPointer >= 0) {
                if (bigStr.charAt(bigArrPointer) == smallStr.charAt(smallArrPointer)) {
                    smallArrPointer--;
                } else {
                    numOfChanges++;
                }
                bigArrPointer--;
            }
        }

        return numOfChanges < 2;
    }

}
