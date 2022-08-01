package src.main.pro.xw.leetcode.generatethestring;

public class Solution {

    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        if (n <= 1) {
            return "a";
        }
        int mod = n % 2;
        int aCount = 0;
        int bCount = 0;
        if (mod == 0) {
            aCount = n - 1;
            bCount = 1;
        } else {
            aCount = n;
        }

        StringBuilder  stringBuilder = new StringBuilder();
        for (int i = 0; i < aCount; i++) {
            stringBuilder.append("a");
        }
        if (bCount == 1) {
            stringBuilder.append("b");
        }
        return stringBuilder.toString();
    }
}
