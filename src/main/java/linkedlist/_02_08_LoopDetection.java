package linkedlist;

import java.util.HashSet;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * <p>
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * <p>
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[the same C as earlier]
 * Output: C
 */
class _02_08_LoopDetection {

    LinkedListNode detect(LinkedListNode head) {
        if(head == null) return null;

        LinkedListNode curr = head;
        HashSet<LinkedListNode> prevNodes = new HashSet<>();

        while(curr != null) {
            if(prevNodes.contains(curr)) {
                return curr;
            } else {
                prevNodes.add(curr);
            }
            curr = curr.next;
        }

        return null;
    }
}
