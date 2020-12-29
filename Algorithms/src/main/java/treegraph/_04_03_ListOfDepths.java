package treegraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class _04_03_ListOfDepths {

    //time o(N) space o(N)
    List<LinkedList<Integer>> create(BinaryTreeNode node) {
        LinkedList<LinkedList<Integer>> depthLists = new LinkedList<>();

        if(node == null) return depthLists;

        Queue<BinaryTreeNode> treeNodeQueue = new LinkedList();

        treeNodeQueue.add(node);

        while (!treeNodeQueue.isEmpty()) {

            LinkedList<Integer> depth = new LinkedList<>();
            int queueSize = treeNodeQueue.size();

            for(int i = 0; i < queueSize; i++) {
                BinaryTreeNode currNode = treeNodeQueue.poll();

                if(currNode.left != null) {
                    treeNodeQueue.offer(currNode.left);
                }
                if(currNode.right != null) {
                    treeNodeQueue.offer(currNode.right);
                }

                depth.add(currNode.val);
            }

            depthLists.add(depth);
        }

        return depthLists;
    }
}
