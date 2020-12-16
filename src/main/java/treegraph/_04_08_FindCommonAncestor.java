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
        HashSet<ParentAwareBinaryTreeNode> ancestorsB = new HashSet<>();

        while(currB != null) {
            ancestorsB.add(currB);
            currB = currB.parent;
        }

        while(currA != null) {
            if(ancestorsB.contains(currA)) return currA;
            currA = currA.parent;
        }

        return null;
    }


}
