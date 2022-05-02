package hank.leetcode.array;

/**
 * <a href ='https://leetcode-cn.com/problems/range-sum-query-2d-immutable/'>
 * <h2>Leetcode 304. 二维区域和检索 - 矩阵不可变</h2>
 * </a>
 * <h2>解题思路</h2>
 * <a href='https://labuladong.github.io/algo/2/18/21/'>前缀和数组算法</a>
 *
 * @author hank
 */
public class NumMatrix {
    private final int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length + 1;
        int col = matrix[0].length + 1;
        sumMatrix = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sumMatrix[i][j] = matrix[i - 1][j - 1] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7}
        });
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1] + sumMatrix[row1][col1];
    }
}
