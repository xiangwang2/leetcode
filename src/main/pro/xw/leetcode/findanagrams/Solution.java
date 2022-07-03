package src.main.pro.xw.leetcode.findanagrams;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
    }


    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        int[] pChars = new int[26];
        int[] subSChars = new int[26];

        p.chars().forEach(x -> pChars[x - 'a'] += 1);

        char[] sChars = s.toCharArray();

        for (int i = 0; i < p.length(); i++) {
            subSChars[sChars[i] - 'a'] += 1;
        }

        boolean isAnagram = true;
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (i > 0) {
                subSChars[sChars[i - 1] - 'a'] -= 1;
                subSChars[sChars[i + s.length() - 1] - 'a'] += 1;
            }
            for (int j = 0; j < 26; j++) {
                if (pChars[i] != subSChars[i]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) {
                res.add(i);
            }
        }

        return res;
    }
}
