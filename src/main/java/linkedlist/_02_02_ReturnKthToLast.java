package linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        if(head == null) return null;

        LinkedListNode curr = head;
        int length = 0;

        while(curr != null) {
            length++;
            curr = curr.next;
        }

        if(k > length - 1 || k < 0) return null;

        curr = head;
        int currPos = 0;
        while(currPos != length - 1 - k) {
            currPos++;
            curr = curr.next;
        }
        return curr;
    }
}
