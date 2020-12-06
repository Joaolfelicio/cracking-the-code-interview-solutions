package linkedlist;

import java.util.HashSet;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is de ned based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 */
class _02_07_Intersection {

    LinkedListNode intersects(LinkedListNode l1, LinkedListNode l2) {
        if(l1 == null || l2 == null) return null;

        LinkedListNode currL1 = l1;
        LinkedListNode currL2 = l2;
        int l1Length = 0;
        int l2Length = 0;

        // Get the length of the linked list and the tails
        while(currL1.next != null || currL2.next != null) {
            if(currL1.next != null) {
                l1Length++;
                currL1 = currL1.next;
            }

            if(currL2.next != null) {
                l2Length++;
                currL2 = currL2.next;
            }
        }

        // If the tails are different, the lists don't intersect
        if(currL1 != currL2) return null;

        LinkedListNode biggerList = l1Length > l2Length ? l1 : l2;
        LinkedListNode smallerList = l1Length > l2Length ? l2 : l1;

        int differenceLength = Math.abs(l1Length - l2Length);

        // Move the bigger list the difference between the length of both lists
        while(differenceLength > 0) {
            biggerList = biggerList.next;
            differenceLength--;
        }

        while(biggerList != smallerList) {
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }

        return biggerList;
    }
}
