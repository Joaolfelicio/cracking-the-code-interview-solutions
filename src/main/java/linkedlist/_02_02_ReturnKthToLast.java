package linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLastTwoPass(LinkedListNode head, int k) {
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

    // Time complexity would be O(N), while the above would be O(2N)
    LinkedListNode kthToLast(LinkedListNode head, int k) {
        if(head == null) return null;

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        int tempK = k + 1;

        while(fast != null) {

            if(tempK > 0) {
                tempK--;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return tempK > 0 ? null : slow;
    }
}

