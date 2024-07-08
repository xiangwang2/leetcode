package src.main.pro.xw.leetcode.pivotIndex;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{-1, -1, 0, 1, 1, 0}));
    }

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int index = 0;
        int prefixSum = 0;
        while (index < nums.length) {
            if (prefixSum * 2 + nums[index] == totalSum) {
                return index;
            }
            prefixSum += nums[index];
            index++;
        }
        return -1;
    }
}
