package linkedlist;

import java.util.Stack;

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
        LinkedListNode dummyList = new LinkedListNode(0);
        LinkedListNode curr = dummyList;

        int carry = 0;

        while(currL1 != null || currL2 != null) {

            int valL1 = 0;
            int valL2 = 0;

            if(currL1 != null) {
                valL1 = currL1.val;
                currL1 = currL1.next;
            }

            if(currL2 != null) {
                valL2 = currL2.val;
                currL2 = currL2.next;
            }

            int val = valL1 + valL2 + carry;

            carry = 0;

            if(val > 9) carry = 1;

            curr.next = new LinkedListNode(val % 10);

            curr = curr.next;
        }

        if(carry > 0) curr.next = new LinkedListNode(carry);

        return dummyList.next;
    }

    LinkedListNode sumFollowUp(LinkedListNode l1, LinkedListNode l2) {

        LinkedListNode currL1 = l1;
        LinkedListNode currL2 = l2;
        Stack<Integer> stackL1 = new Stack<>();
        Stack<Integer> stackL2 = new Stack<>();

        while(currL1 != null || currL2 != null) {
            if(currL1 != null) {
                stackL1.push(currL1.val);
                currL1 = currL1.next;
            }

            if(currL2 != null) {
                stackL2.push(currL2.val);
                currL2 = currL2.next;
            }
        }

        LinkedListNode prev = null;
        int carry = 0;

        while(!stackL1.empty() || !stackL2.empty()) {
            int valL1 = 0;
            int valL2 = 0;

            if(!stackL1.empty()) valL1 = stackL1.pop();
            if(!stackL2.empty()) valL2 = stackL2.pop();

            int val = valL1 + valL2 + carry;
            carry = 0;
            if(val > 9) carry = 1;

            LinkedListNode newNode = new LinkedListNode(val % 10);
            newNode.next = prev;
            prev = newNode;
        }

        if(carry > 0) {
            LinkedListNode carryNode = new LinkedListNode(carry);
            carryNode.next = prev;
            prev = carryNode;
        };

        return prev;
    }
}
