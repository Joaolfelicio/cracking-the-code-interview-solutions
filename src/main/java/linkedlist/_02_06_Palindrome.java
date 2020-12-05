package linkedlist;

import java.util.Stack;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {

    boolean isPalindrome(LinkedListNode head) {
        if(head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If it's an odd list
        if(fast != null)
            slow = slow.next;

        LinkedListNode reverseHead = reverseLinkedList(slow);
        slow = head;

        while(reverseHead != null) {
            if(slow.val != reverseHead.val) return false;

            slow = slow.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private LinkedListNode reverseLinkedList(LinkedListNode node) {

        LinkedListNode curr = node;
        LinkedListNode prev = null;

        while(curr != null) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
