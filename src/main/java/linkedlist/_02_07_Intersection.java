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

        LinkedListNode currL1 = l1;
        LinkedListNode currL2 = l2;
        HashSet<LinkedListNode> nodesSet = new HashSet<>();

        while(currL1 != null) {
            nodesSet.add(currL1);
            currL1 = currL1.next;
        }

        while (currL2 != null) {
            if(nodesSet.contains(currL2)) return currL2;
            currL2 = currL2.next;
        }
        return null;
    }
}
