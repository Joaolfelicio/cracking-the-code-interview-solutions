package linkedlist;

import java.util.Stack;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output:2 -> 1 -> 9.That is,912.
 */
class _02_05_SumListReverse {
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
}
