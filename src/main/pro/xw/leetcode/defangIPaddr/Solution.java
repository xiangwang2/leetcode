package src.main.pro.xw.leetcode.defangIPaddr;

public class Solution {

    public static void main(String[] args) {

    }

    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        char[] res = new char[chars.length + 6];

        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                res[j] = '[';
                j++;
                res[j] = '.';
                j++;
                res[j] = ']';
                j++;
            } else {
                res[j] = chars[i];
                j++;
            }
        }
        return new String(res);
    }
}
