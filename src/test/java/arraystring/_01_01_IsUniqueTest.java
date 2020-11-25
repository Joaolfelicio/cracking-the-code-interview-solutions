package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _01_01_IsUniqueTest {

    private _01_01_IsUnique s = new _01_01_IsUnique();

    @Test
    public void withEmptyStringHashSet() {
        assertTrue(s.isUniqueHashSet(""));
    }

    @Test
    public void withUniqueStringHashSet() {
        assertTrue(s.isUniqueHashSet("abcde"));
    }

    @Test
    public void withDuplicationHashSet() {
        assertFalse(s.isUniqueHashSet("abcda"));
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

    @Test
    public void withEmptyStringBoolArr() {
        assertTrue(s.isUniqueBoolArr(""));
    }

    @Test
    public void withUniqueStringBoolArr() {
        assertTrue(s.isUniqueBoolArr("abcde"));
    }

    @Test
    public void withDuplicationBoolArr() {
        assertFalse(s.isUniqueBoolArr("abcda"));
    }

    @Test
    public void withEmptyStringBitVector() {
        assertTrue(s.isUniqueBitVector(""));
    }

    @Test
    public void withUniqueStringBitVector() {
        assertTrue(s.isUniqueBitVector("abcde"));
    }

    @Test
    public void withDuplicationBitVector() {
        assertFalse(s.isUniqueBitVector("abcda"));
    }
}