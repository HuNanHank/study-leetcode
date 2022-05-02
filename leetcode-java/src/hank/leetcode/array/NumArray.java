package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/range-sum-query-immutable/'>
 * <h2>Leetcode 303. 区域和检索 - 数组不可变</h2>
 * </a>
 * <h2>解题思路</h2>
 * <a href='https://labuladong.github.io/algo/2/18/21/'>前缀和数组算法</a>
 *
 * @author hank
 */
public class NumArray {
    private final int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    @Override
    public String toString() {
        return "NumArray{" +
                "sums=" + Arrays.toString(sums) +
                '}';
    }
}
