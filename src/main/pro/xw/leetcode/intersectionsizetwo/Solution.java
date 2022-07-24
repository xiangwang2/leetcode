package src.main.pro.xw.leetcode.intersectionsizetwo;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int min = intervals[0][1] - 1;
        int max = intervals[intervals.length - 1][0] + 1;
        return max - min + 1;
    }
}
