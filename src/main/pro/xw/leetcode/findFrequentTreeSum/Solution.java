package src.main.pro.xw.leetcode.findFrequentTreeSum;


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
    Map<Integer, Integer> sumMap = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> resList = new LinkedList<>();

        sumTreeNode(root);

        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue() == max) {
                resList.add(entry.getKey());
            }
        }

        int[] res = new int[resList.size()];
        int i = 0;
        for (int sum : resList) {
            res[i] = sum;
            i++;
        }
        return res;
    }

    private int sumTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = sumTreeNode(root.left) + root.val + sumTreeNode(root.right);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        max = Math.max(max, sumMap.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
    }

}
