package src.main.pro.xw.leetcode.unhappyfriends;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, (x, y) -> - (x+y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i< nums.length; i++) {
            res.append(numsStr[i]);
        }
        String temp = res.toString();
        while (temp.length() >= 2 && temp.startsWith("0")) {
            temp = temp.substring(1);
        }
        return temp;
    }
}
