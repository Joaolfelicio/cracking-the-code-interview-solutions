package linkedlist;

import java.util.LinkedList;

/**
 * Implement an algorithm to delete a node in the
 * middle(i.e., any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node.
 */
class _02_03_DeleteMiddleNode {

    boolean deleteMiddleNode(LinkedListNode head) {

        if(head == null || head.next == null || head.next.next == null) return false;

        LinkedListNode slow = head;
        LinkedListNode fast = head.next.next;
        LinkedListNode prev = null;

        while(fast != null) {

            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;

        return true;
    }
}
