package src.main.pro.xw.leetcode.nextGreaterElement;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(s.nextGreaterElement(2147483476));
    }

    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();

        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) {
            j--;
        }
        if (j < 0) {
            return -1;
        }

        int minOverJIndex = j + 1;
        int minOverJ = nums[minOverJIndex];
        for (int i = j + 1; i < nums.length ; i++) {
            if (nums[i] < minOverJ && nums[i] > nums[j]) {
                minOverJ = nums[i];
                minOverJIndex = i;
            }
        }
        swap(nums, minOverJIndex, j);
        reverse(nums, j + 1);
        long res = Long.parseLong(new String(nums));
        return (res > Integer.MAX_VALUE) ? -1 : (int) res;
    }

    public void reverse(char[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j ] < nums[j - 1]) {
                    swap(nums, j , j - 1);
                }
            }
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
