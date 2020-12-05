package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _02_05_SumListTest {

    private _02_05_SumList s = new _02_05_SumList();

    @Test
    public void withTwoEmptyLists() {
        assertEquals(LinkedListNode.empty(), s.sum(LinkedListNode.empty(), LinkedListNode.empty()));
    }

    @Test
    public void withOneEmptyList() {
        assertEquals(LinkedListNode.of(1, 2, 3), s.sum(LinkedListNode.empty(), LinkedListNode.of(1, 2, 3)));
    }

    @Test
    public void withNoCarry() {
        assertEquals(LinkedListNode.of(2, 4, 6), s.sum(LinkedListNode.of(1, 2, 3), LinkedListNode.of(1, 2, 3)));
    }

    @Test
    public void withCarry() {
        assertEquals(LinkedListNode.of(5, 3, 5), s.sum(LinkedListNode.of(1, 8, 3), LinkedListNode.of(3, 5, 2)));
    }

    @Test
    public void withCarryAtEnd() {
        assertEquals(LinkedListNode.of(1, 1, 4, 1), s.sum(LinkedListNode.of(1, 8, 9), LinkedListNode.of(9, 5, 2)));
    }

    @Test
    public void withTwoListsHavingDiffrentLength() {
        assertEquals(LinkedListNode.of(2, 4, 1), s.sum(LinkedListNode.of(1, 8, 9), LinkedListNode.of(5, 2)));
    }

    @Test
    public void withProvidedExample() {
        assertEquals(LinkedListNode.of(1, 3, 0, 8), s.sum(LinkedListNode.of(7, 1, 6), LinkedListNode.of(5, 9, 2)));
    }

    @Test
    public void withProvidedExampleAndCarry() {
        assertEquals(LinkedListNode.of(1, 3, 1, 0), s.sum(LinkedListNode.of(7, 1, 6), LinkedListNode.of(5, 9, 4)));
    }

    @Test
    public void withProvidedExampleDifferentQuantityDigits() {
        assertEquals(LinkedListNode.of(9, 1, 1, 2), s.sum(LinkedListNode.of(8, 6, 1, 7), LinkedListNode.of(4, 9, 5)));
    }
}