package src.main.pro.xw.leetcode.modifiedMatrix;

public class Main {

    public static void main(String[] args) {

    }

    public int[][] modifiedMatrix(int[][] matrix) {
        int[] max = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }
        return matrix;
    }
}
