package arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale,  ple   -> true
 * pales, paes  -> true
 * pale,  bale  -> true
 * pale,  bake  -> false
 * pae,   pale  -> true
 * paxye, paxe -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
        String bigStr = a.length() > b.length() ? a : b;
        String smallStr = a.length() > b.length() ? b : a;

        if(smallStr.length() + 1 < bigStr.length()) return false;

        int changesAvailable = 1;
        int bigArrPointer = 0;
        int smallArrPointer = 0;


        while(changesAvailable >= 0 && bigArrPointer < bigStr.length() - 1 && smallArrPointer < smallStr.length() - 1) {
            if (bigStr.charAt(bigArrPointer) == smallStr.charAt(smallArrPointer)) {
                smallArrPointer++;
            } else {
                changesAvailable--;
                if(bigStr.length() == smallStr.length()) {
                    smallArrPointer++;
                }
            }
            bigArrPointer++;
        }

        return changesAvailable >= 0;
    }

}
