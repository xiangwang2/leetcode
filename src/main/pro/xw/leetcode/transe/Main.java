package src.main.pro.xw.leetcode.transe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Character, Integer> valueMap = new HashMap<Character, Integer>() {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null && !str.equals("")) {
            str = str.replaceFirst("0x", "");
            char[] chars = str.toCharArray();
            int sum = 0;
            int base = chars.length - 1;
            for (char c : chars) {
                sum += valueMap.getOrDefault(c, 0) * Math.pow(16, base);
                base--;
            }
            System.out.println(sum);
            str = br.readLine();
        }
    }


}
