package treegraph;

/**
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of T1.
 * <p>
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 */
class _04_10_CheckSubTree {

    boolean isSubTree(BinaryTreeNode a, BinaryTreeNode b) {
        return a != null && ( isEqual(a, b) || isSubTree(a.left, b) || isSubTree(a.right, b));
    }

    private boolean isEqual(BinaryTreeNode a, BinaryTreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;

        return a.val == b.val && isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
