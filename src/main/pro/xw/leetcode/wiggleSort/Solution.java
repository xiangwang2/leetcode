package src.main.pro.xw.leetcode.wiggleSort;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        s.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int[] arrayCopy = new int[nums.length];

        System.arraycopy(nums, 0, arrayCopy, 0, nums.length);

        int length = nums.length;

        for (int i = 0, j = 0, p = length - 1; i < length; i++, j++, p--) {
            nums[i] = arrayCopy[j];
            nums[++i] = arrayCopy[p];
        }
    }
}
