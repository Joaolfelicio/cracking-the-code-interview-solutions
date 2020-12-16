package treegraph;

import java.util.HashSet;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
class _04_08_FindCommonAncestor {

    ParentAwareBinaryTreeNode findCommonAncestor(ParentAwareBinaryTreeNode a, ParentAwareBinaryTreeNode b) {
        if(a == null || b == null) return null;

        ParentAwareBinaryTreeNode currA = a;
        ParentAwareBinaryTreeNode currB = b;

        while(currA != currB) {
            currA = currA.parent;
            currB = currB.parent;

            if(currA == null) {
                currA = b;
            }
            if(currB == null) {
                currB = a;
            }
        }
        return currA;
    }


}
