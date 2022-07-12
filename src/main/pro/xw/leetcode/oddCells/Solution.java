package src.main.pro.xw.leetcode.oddCells;

public class Solution {

    public static void main(String[] args) {

    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] mn = new int[m][n];
        for (int[] indice : indices) {
            int row = indice[0];
            int col = indice[1];

            for (int i = 0; i < mn[row].length; i++) {
                mn[row][i] += 1;
            }
            for (int i = 0; i < mn.length; i++) {
                mn[i][col] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < mn.length; i++) {
            for (int j = 0; j < mn[0].length; j++) {
                if (mn[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
