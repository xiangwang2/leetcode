package src.main.pro.xw.leetcode.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        str = br.readLine();
        while (!str.equals("0")) {
            dealWater(str);
            str = br.readLine();
        }
    }

    private static void dealWater(String s) {
        int water = 0;
        int bottle = Integer.parseInt(s);
        int sum = 0;
        while (bottle >= 2 ) {
            if (bottle == 2) {
                sum += 1;
                bottle = 0;
            }else  {
                water = bottle / 3;
                bottle = bottle % 3;
                sum += water;
                bottle += water;
            }
        }
        System.out.println(sum);
    }
}
