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
        LinkedListNode fast = head.next.next;
        
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        stack.push(slow.val);

        if(fast == null)
            slow = slow.next;
        else if(fast.next == null)
            slow = slow.next.next;

        while(slow != null) {
            if(slow.val != stack.pop()) return false;
            slow = slow.next;
        }

        return stack.isEmpty();
    }


}
