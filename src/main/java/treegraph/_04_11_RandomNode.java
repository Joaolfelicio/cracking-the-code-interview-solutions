package treegraph;

import java.util.Random;

/**
 * You are implementing a binary tree class from scratch
 * which, in addition to insert, find, and delete, has a method getRandomNode()
 * which returns a random node from the tree.
 * <p>
 * All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode,
 * and explain how you would implement the rest of the methods.
 */
class _04_11_RandomNode {

    public class Node {

        Node(int val) {
            this.val = val;
        }

        public int val;
        public int numOfChildren;
        public Node left;
        public Node right;
    }

    static class Tree {

        private Node root;

        void insert(int val) {
            throw new UnsupportedOperationException();
        }

        Node find(int val) { throw new UnsupportedOperationException(); }

        Node getRandomNode() {
            int randomIndex = new Random().nextInt(root.numOfChildren + 1);
            return getRandomNode(root, randomIndex);
        }

        private Node getRandomNode(Node current, int index) {
            if(countChildren(current) == index) return current;
            if(countChildren(current.left) > index) return getRandomNode(current.left, index);
            return getRandomNode(current.right, index - countChildren(current.right) - 1);
        }

        private int countChildren(Node current) {
            if(current == null) return 0;
            return current.numOfChildren + 1;
        }
    }
}
