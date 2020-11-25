package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _01_01_IsUniqueTest {

    private _01_01_IsUnique s = new _01_01_IsUnique();

    @Test
    public void withEmptyString() {
        assertTrue(s.isUnique(""));
    }

    @Test
    public void withUniqueString() {
        assertTrue(s.isUnique("abcde"));
    }

    @Test
    public void withDuplication() {
        assertFalse(s.isUnique("abcda"));
    }

    @Test
    public void withEmptyStringBruteForce() {
        assertTrue(s.isUniqueBruteForce(""));
    }

    @Test
    public void withUniqueStringBruteForce() {
        assertTrue(s.isUniqueBruteForce("abcde"));
    }

    @Test
    public void withDuplicationBruteForce() {
        assertFalse(s.isUniqueBruteForce("abcda"));
    }

}