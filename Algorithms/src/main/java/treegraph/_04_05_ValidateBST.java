package treegraph;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
class _04_05_ValidateBST {

    boolean isBST(BinaryTreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBST(BinaryTreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

}
