package src.main.pro.xw.leetcode.prunetree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return null;
        }
        Map<TreeNode, Integer> subSum = new HashMap<>();
        subSum.put(null, 0);
        return pruneTree(root, subSum);
    }

    private TreeNode pruneTree(TreeNode root, Map<TreeNode, Integer> subMap) {
        if (root == null) {
            return null;
        }
        pruneTree(root.left, subMap);
        pruneTree(root.right, subMap);

        if (subMap.getOrDefault(root.left, 0) == 0) {
            root.left = null;
        }
        if (subMap.getOrDefault(root.right, 0) == 0) {
            root.right = null;
        }
        return root;
    }

    private int sumTree(TreeNode treeNode, Map<TreeNode, Integer> subMap) {
        return 0;
    }
}


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
