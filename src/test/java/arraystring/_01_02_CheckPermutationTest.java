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
    public void withRepeatingCharsHashMap() { assertTrue(s.checkPermutationWithHashMap("aabbc", "bcaba")); }

    @Test
    public void withDifferentLengthHashMap() {
        assertFalse(s.checkPermutationWithArray("abc", "ab"));
    }

    @Test
    public void withEmptyStringArray() {
        assertTrue(s.checkPermutationWithArray("", ""));
    }

    @Test
    public void withOneSingleCharArray() {
        assertTrue(s.checkPermutationWithArray("a", "a"));
    }

    @Test
    public void withOneSingleDifferentCharArray() {
        assertFalse(s.checkPermutationWithArray("a", "b"));
    }

    @Test
    public void withThreeCharsArray() {
        assertTrue(s.checkPermutationWithArray("abc", "bac"));
    }

    @Test
    public void withRepeatingCharsArray() { assertTrue(s.checkPermutationWithArray("aabbc", "bcaba")); }

    @Test
    public void withDifferentLengthArray() {
        assertFalse(s.checkPermutationWithHashMap("abc", "ab"));
    }
}