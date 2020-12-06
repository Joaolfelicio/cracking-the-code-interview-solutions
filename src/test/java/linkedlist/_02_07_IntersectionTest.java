package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class _02_07_IntersectionTest {

    private _02_07_Intersection s = new _02_07_Intersection();

    @Test
    public void withTwoEmptyLists() {

        assertEquals(null, s.intersects(LinkedListNode.empty(), LinkedListNode.empty()));
    }

    @Test
    public void withOneEmptyList() {
        assertEquals(null, s.intersects(LinkedListNode.empty(), LinkedListNode.of(1, 2, 3)));
        assertEquals(null, s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.empty()));
    }

    @Test
    public void withTwoSeparatedLists() {
        assertEquals(null, s.intersects(LinkedListNode.of(1, 2, 3), LinkedListNode.of(4, 2, 6)));
    }

    @Test
    public void withIntersectedLists() {
        LinkedListNode l1 = LinkedListNode.of(1, 2, 3, 4, 5);
        LinkedListNode l2 = LinkedListNode.of(6, 7, 8);
        l2.next.next.next = l1.next;
        assertEquals(l1.next, s.intersects(l1, l2));
    }
}