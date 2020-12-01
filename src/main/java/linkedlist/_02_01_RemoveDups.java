package linkedlist;

import java.util.HashSet;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        LinkedListNode dummyHead = new LinkedListNode(Integer.MIN_VALUE, head);

        HashSet<Integer> uniqueVals = new HashSet<>();

        LinkedListNode curr = dummyHead.next;
        LinkedListNode prev = dummyHead;

        while(curr != null) {

            if(uniqueVals.add(curr.val)) {
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }
        prev.next = null;

        return dummyHead.next;
    }
}
