package treegraph;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */
class _04_04_CheckBalanced {

    //time o(N) space o(logN)
    boolean isBalanced(BinaryTreeNode root) {
        if(root == null) return true;

        int height = isBalancedTree(root);

        return height != -1;
    }

    int isBalancedTree(BinaryTreeNode node) {
        if(node == null) return -1;

        int depthLeft = isBalancedTree(node.left);
        int depthRight = isBalancedTree(node.right);

        if(Math.abs(depthLeft - depthRight) > 1) {
            return -1;
        }

        return Math.max(depthLeft, depthRight) + 1;
    }
}
