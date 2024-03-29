package linkedlist;

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
class _02_04_Partition {

    LinkedListNode partition(LinkedListNode head, int x) {

        LinkedListNode below = new LinkedListNode(0);
        LinkedListNode aboveOrEqual = new LinkedListNode(0);
        LinkedListNode currBelow = below;
        LinkedListNode currAboveOrEqual = aboveOrEqual;

        while(head != null) {
            if(head.val < x) {
                currBelow.next = head;
                currBelow = currBelow.next;
            } else {
                currAboveOrEqual.next = head;
                currAboveOrEqual = currAboveOrEqual.next;
            }
            head = head.next;
        }
        currAboveOrEqual.next = null;
        currBelow.next = aboveOrEqual.next;
        return below.next;
    }
}
