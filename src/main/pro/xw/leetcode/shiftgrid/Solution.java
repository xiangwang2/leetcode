package src.main.pro.xw.leetcode.shiftgrid;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution solution = new Solution();
        solution.shiftGrid(grid, 1);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int allSize = m * n;

        k = k % allSize;
        int[] list = new int[allSize];

        int index = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                list[index++] = ints[j];
            }
        }

        int[] sub = new int[k];
        System.arraycopy(list, allSize - k, sub, 0, k);
        System.arraycopy(list, 0, list, k, allSize - k);
        System.arraycopy(sub, 0, list, 0, k);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < list.length; i += n) {
            List<Integer> temp = new LinkedList<>();
            for (int j = i; j < i + n; j++) {
                temp.add(list[j]);
            }
            res.add(temp);
        }
        return res;
    }
}
