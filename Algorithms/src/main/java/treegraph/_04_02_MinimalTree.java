package treegraph;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
class _04_02_MinimalTree {

    BinaryTreeNode buildMinimalTree(int[] vals) {
        if(vals.length == 0) return null;

        return buildTree(vals, 0, vals.length - 1);
    }

    BinaryTreeNode buildTree(int[] vals, int left, int right) {
        if(left > right) return null;

        int midIndex = left + (right - left) / 2;

        BinaryTreeNode node = new BinaryTreeNode(vals[midIndex]);

        node.left = buildTree(vals, left, midIndex - 1);
        node.right = buildTree(vals, midIndex + 1, right);

        return node;
    }
}
