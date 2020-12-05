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
        assertEquals(LinkedListNode.of(6, 4, 2), s.sum(LinkedListNode.of(3, 2, 1), LinkedListNode.of(3, 2, 1)));
    }

    @Test
    public void withCarry() {
        assertEquals(LinkedListNode.of(5, 3, 5), s.sum(LinkedListNode.of(3, 8, 1), LinkedListNode.of(2, 5, 3)));
    }

    @Test
    public void withCarryAtEnd() {
        assertEquals(LinkedListNode.of(1, 4, 1, 1), s.sum(LinkedListNode.of(9, 8, 1), LinkedListNode.of(2, 5, 9)));
    }

    @Test
    public void withTwoListsHavingDiffrentLength() {
        assertEquals(LinkedListNode.of(1, 4, 2), s.sum(LinkedListNode.of(9, 8, 1), LinkedListNode.of(2, 5)));
    }

    @Test
    public void withProvidedExample() {
        assertEquals(LinkedListNode.of(2, 1, 9), s.sum(LinkedListNode.of(7, 1, 6), LinkedListNode.of(5, 9, 2)));
    }

    @Test
    public void withProvidedExampleAndCarry() {
        assertEquals(LinkedListNode.of(2, 1, 1, 1), s.sum(LinkedListNode.of(7, 1, 6), LinkedListNode.of(5, 9, 4)));
    }

    @Test
    public void withProvidedExampleDifferentQuantityDigits() {
        assertEquals(LinkedListNode.of(2, 6, 7, 7), s.sum(LinkedListNode.of(8, 6, 1, 7), LinkedListNode.of(4, 9, 5)));
    }
}