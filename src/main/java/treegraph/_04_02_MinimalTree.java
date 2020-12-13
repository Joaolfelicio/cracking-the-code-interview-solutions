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

    BinaryTreeNode buildTree(int[] vals, int p1, int p2) {
        if(p1 > p2) return null;

        int midIndex = p1 + (p2 - p1) / 2;

        BinaryTreeNode node = new BinaryTreeNode(vals[midIndex]);

        node.left = buildTree(vals, p1, midIndex - 1);
        node.right = buildTree(vals, midIndex + 1, p2);

        return node;
    }
}
