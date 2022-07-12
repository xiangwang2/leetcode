package src.main.pro.xw.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Set<Integer> values = new HashSet<>();
        while (count > 0) {
            values.add(Integer.parseInt(br.readLine()));
            count--;
        }
        int[] arrayValues = new int[values.size()];
        int index = 0;
        for (int temp : values) {
            arrayValues[index] = temp;
            index++;
        }
        Arrays.sort(arrayValues);
        Arrays.stream(arrayValues).forEach(System.out::println);
    }
}
