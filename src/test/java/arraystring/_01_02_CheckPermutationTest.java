package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _01_02_CheckPermutationTest {

    private _01_02_CheckPermutation s = new _01_02_CheckPermutation();

    @Test
    public void withEmptyStringHashMap() {
        assertTrue(s.checkPermutationWithHashMap("", ""));
    }

    @Test
    public void withOneSingleCharHashMap() {
        assertTrue(s.checkPermutationWithHashMap("a", "a"));
    }

    @Test
    public void withOneSingleDifferentCharHashMap() {
        assertFalse(s.checkPermutationWithHashMap("a", "b"));
    }

    @Test
    public void withThreeCharsHashMap() {
        assertTrue(s.checkPermutationWithHashMap("abc", "bac"));
    }

    @Test
    public void withRepeatingCharsHashMap() { assertTrue(s.checkPermutationWithHashMap("aabbc", "bcaba"));
    }

    @Test
    public void withDifferentLengthHashMap() {
        assertFalse(s.checkPermutationWithHashMap("abc", "ab"));
    }
}