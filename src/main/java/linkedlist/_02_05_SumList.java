package linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in normal order, such that the 1 's digit is at the tail of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 *
 * EXAMPLE FOLLOW UP
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 716 + 592.
 * Output: 1 -> 4 -> 0 -> 8. That is, 1408.
 */
class _02_05_SumList {

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {

        LinkedListNode currL1 = l1;
        LinkedListNode currL2 = l2;

        int sum = sumLinkedList(currL2) + sumLinkedList(currL1);

        LinkedListNode dummyList = new LinkedListNode(0);
        LinkedListNode curr = dummyList;

        while(sum > 0) {
            curr.next = new LinkedListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }

        return dummyList.next;
    }

    int sumLinkedList(LinkedListNode node) {
        int multiplier = 1;
        int total = 0;

        while (node != null) {
            total += node.val * multiplier;
            multiplier *= 10;
            node = node.next;
        }
        return total;
    }
}
