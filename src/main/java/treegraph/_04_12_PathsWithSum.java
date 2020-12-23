package treegraph;

import java.util.HashMap;

/**
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that target to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 */
class _04_12_PathsWithSum {

    int countPathWithSum(BinaryTreeNode node, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(node, 0, sum, preSum);
    }

    private int helper(BinaryTreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
