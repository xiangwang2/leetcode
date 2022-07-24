package src.main.pro.xw.leetcode.asteroidCollision;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i : asteroids) {
            if (i > 0) {
                queue.add(i);
            } else {
                while (!queue.isEmpty() && queue.peekLast() > 0 && queue.peekLast() < Math.abs(i)) {
                    queue.pollLast();
                }
                if (!queue.isEmpty() && queue.peekLast() > 0 && queue.peekLast() == Math.abs(i)) {
                    queue.pollLast();
                } else {
                    if (queue.isEmpty() || queue.peekLast() < 0) {
                        queue.add(i);
                    }
                }
            }
        }

        int[] res = new int[queue.size()];
        int index = 0;
        for (int asteroid : queue) {
            res[index] = asteroid;
            index++;
        }
        return res;
    }
}
