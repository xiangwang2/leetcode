package src.main.pro.xw.leetcode.duplicateZeros;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        s.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;

        for (int var : arr) {
            if (var == 0) {
                zeroCount++;
            }
        }

        for (int j = arr.length - 1; j > 0; j--) {
            int index = j + zeroCount;
            if (index < arr.length) {
                arr[index] = arr[j];
            }
            if (arr[j] == 0) {
                zeroCount--;
                if (index - 1 < arr.length) {
                    arr[index-1] = 0;
                }
            }
        }
    }
}
