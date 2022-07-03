package src.main.pro.xw.leetcode.minimumAbsDifference;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Map<Integer, List<List<Integer>>> resMap = new HashMap<>();
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int abs = arr[i + 1] - arr[i];
            if (abs < minAbs) {
                minAbs = abs;
            }
            List<Integer> pair = new ArrayList<>(2);
            pair.add(arr[i]);
            pair.add(arr[i + 1]);
            List<List<Integer>> pairs = resMap.getOrDefault(abs, new LinkedList<>());
            pairs.add(pair);
            resMap.put(abs, pairs);
        }

        return resMap.get(minAbs);
    }
}
