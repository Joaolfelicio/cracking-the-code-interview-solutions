package linkedlist;

import java.util.HashSet;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        LinkedListNode dummyHead = new LinkedListNode(0, head);

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

    LinkedListNode removeDupsWithOutExtraSpace(LinkedListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        LinkedListNode p1 = head;

        while(p1 != null) {
            LinkedListNode p2 = p1;

            while(p2 != null && p2.next != null) {
                if(p1.val == p2.next.val) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
        return head;
    }
}
