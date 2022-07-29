package src.main.pro.xw.leetcode.pathSum;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new LinkedList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<List<Integer>> allRes = new LinkedList<>();
        Map<TreeNode, Boolean> isLeaf = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null) {
                if (!isLeaf.containsKey(top)) {
                    List<Integer> path = new LinkedList<>();
                    for (TreeNode treeNode : stack) {
                        path.add(treeNode.val);
                    }
                    allRes.add(path);
                }
                stack.pop();
            } else {
                isLeaf.put(top, false);
                if (top.left != null) {
                    stack.push(top.left);
                    top.left = null;
                } else {
                    stack.push(top.right);
                    top.right = null;
                }
            }
        }

        List<List<Integer>> res = new LinkedList<>();

        for(List<Integer> path : allRes) {
            int sum = 0;
            for (int val : path) {
                sum += val;
            }
            if (sum == targetSum) {
                res.add(path);
            }
        }

        return res;
    }
}
