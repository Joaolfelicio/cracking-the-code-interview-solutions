package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

class _01_06_StringCompression {
    String compress(String s) {
        if (s.length() <= 2) return s;

        StringBuilder compressedStr = new StringBuilder();
        int count = 1;

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(i + 1 != s.length() && currentChar == s.charAt(i + 1)) {
                count++;
            } else {
                compressedStr.append(currentChar);
                compressedStr.append(count);
                count = 1;
            }
        }
        return compressedStr.length() < s.length() ? compressedStr.toString() : s;
    }
}
