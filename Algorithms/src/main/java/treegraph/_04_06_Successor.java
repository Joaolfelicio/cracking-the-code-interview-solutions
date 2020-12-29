package treegraph;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */
class _04_06_Successor {
    ParentAwareBinaryTreeNode findInOrderSuccessor(ParentAwareBinaryTreeNode node) {
        if(node == null) return null;

        ParentAwareBinaryTreeNode successor = node;

        if(node.right != null) {
            successor = mostLeftChild(node.right);
        } else {
            while(successor != null && successor.val <= node.val) {
                successor = successor.parent;
            }
        }
        return successor;
    }

    private ParentAwareBinaryTreeNode mostLeftChild(ParentAwareBinaryTreeNode node) {
        if(node == null) return null;

        ParentAwareBinaryTreeNode curr = node;

        while(curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

}
