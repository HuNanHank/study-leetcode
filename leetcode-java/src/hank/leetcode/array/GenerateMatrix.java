package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/spiral-matrix-ii/'>
 * <h2>Leetcode 59. 螺旋矩阵 II</h2>
 * </a>
 * <p>
 * 给你一个正整数n，生成一个包含1到n2所有元素，且元素按顺时针顺序螺旋排列的n x n正方形矩阵matrix。
 * </p>
 * <p>输入：n = 3
 * <p>输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * <h2>解题思路</h2>
 * <a href='https://labuladong.github.io/algo/2/18/24/'>二维数组遍历</a>
 *
 * @author hank
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(new GenerateMatrix().generateMatrix(n)));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int i = 0;
        int j = 0;
        for (int index = 1; index <= n * n; ) {
            while (j <= right && j >= left) {
                matrix[i][j] = index;
                j++;
                index++;
            }
            up++;
            i++;
            j--;
            while (i <= down && j >= up) {
                matrix[i][j] = index;
                i++;
                index++;
            }
            right--;
            j--;
            i--;
            while (j >= left && j <= right) {
                matrix[i][j] = index;
                j--;
                index++;
            }
            down--;
            i--;
            j++;
            while (i <= down && i >= up) {
                matrix[i][j] = index;
                i--;
                index++;
            }
            left++;
            j++;
            i++;
        }
        return matrix;
    }
}
