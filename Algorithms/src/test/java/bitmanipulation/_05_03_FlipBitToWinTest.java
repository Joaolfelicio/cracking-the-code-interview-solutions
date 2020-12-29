package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _05_03_FlipBitToWinTest {

    private _05_03_FlipBitToWin s = new _05_03_FlipBitToWin();

    @Test
    public void withZero() {
        assertEquals(1, s.flip(0));
    }

    @Test
    public void defaultTest() {
        assertEquals(8, s.flip(1775));
    }

    @Test
    public void withAllOnes() {
        assertEquals(32, s.flip(-1));
    }

    @Test
    public void testWithOne() {
        assertEquals(2, s.flip(1));
    }

    @Test
    public void testWithOneSegment() {
        assertEquals(4, s.flip(0x0000_000b));
    }

    @Test
    public void testWithTwoSegments() {
        assertEquals(5, s.flip(0x00b8_000b));
    }

    @Test
    public void WithContinuesSegment() {
        assertEquals(8, s.flip(0x0000_F700));
    }
}