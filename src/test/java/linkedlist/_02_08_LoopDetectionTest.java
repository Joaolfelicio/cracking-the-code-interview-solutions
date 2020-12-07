package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _02_08_LoopDetectionTest {

    private _02_08_LoopDetection s = new _02_08_LoopDetection();

    @Test
    public void withEmptyList() {
        assertNull(s.detect(LinkedListNode.empty()));
    }

    @Test
    public void withListWithoutLoop() {
        assertNull(s.detect(LinkedListNode.of(1, 2, 3)));
    }

}