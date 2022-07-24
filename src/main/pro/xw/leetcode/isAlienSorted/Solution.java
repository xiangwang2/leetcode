package src.main.pro.xw.leetcode.isAlienSorted;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] words = new String[]{"hello", "leetcode"};
//        String order = "hlabcdefgijkmnopqrstuvwxyz";
//        String[] words = new String[]{"word","world","row"};
//        String order = "worldabcefghijkmnpqstuvxyz";
        String[] words = new String[]{"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words, order));

    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (!isAlienSorted(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlienSorted(String word1, String word2, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        int orderNum = 1;
        for (Character c : order.toCharArray()) {
            orderMap.put(c, orderNum);
            orderNum++;
        }

        int max = Math.min(word1.length(), word2.length());

        for (int i = 0; i < max; i++) {
            char a = word1.charAt(i);
            char b = word2.charAt(i);
            int orderA = orderMap.get(a);
            int orderB = orderMap.get(b);
            if (orderA < orderB) {
                return true;
            } else if (orderA > orderB) {
                return false;
            }
        }

        return word1.length() <= word2.length();
    }
}
