package treegraph;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */
class _04_08_FindCommonAncestor {

    ParentAwareBinaryTreeNode findCommonAncestor(ParentAwareBinaryTreeNode root, ParentAwareBinaryTreeNode a, ParentAwareBinaryTreeNode b) {
        return findAncestor(root, a, b);
    }

    ParentAwareBinaryTreeNode findAncestor(ParentAwareBinaryTreeNode current, ParentAwareBinaryTreeNode targetA, ParentAwareBinaryTreeNode targetB) {

        if(current == null) return null;

        if(current == targetA || current == targetB) return current;

        ParentAwareBinaryTreeNode nodeLeft = findAncestor(current.left, targetA, targetB);

        ParentAwareBinaryTreeNode nodeRight = findAncestor(current.right, targetA, targetB);

        //If both are not null, we found the ancestor
        if(nodeLeft != null && nodeRight != null) {
            return current;
        } else if(nodeLeft != null) {
            return nodeLeft;
        } else if(nodeRight != null) {
            return nodeRight;
        }
        return null;
    }
}
