package hank.leetcode.array.binarysearch;

import java.util.Random;

/**
 * <a href ='https://leetcode-cn.com/problems/random-pick-with-weight/'>
 * <h2>Leetcode 528. 按权重随机选择</h2>
 * </a>
 * <p>
 * 给你一个下标从0开始的正整数数组w，其中w[i]代表第i个下标的权重。
 * 请你实现一个函数pickIndex，它可以随机地从范围[0, w.length - 1]内（含 0 和 w.length - 1）选出并返回一个下标。
 * 选取下标 i 的概率为 w[i] / sum(w)。
 * </p>
 * <p>
 * <h2>解题思路</h2>
 * <a href ='https://labuladong.github.io/algo/2/18/27/'>带权重的随机选择算法</a>
 * </p>
 *
 * @author hank
 */
public class RandomPickByWeight {
    private final int[] preSum;
    private final Random random = new Random();

    public RandomPickByWeight(int[] w) {
        preSum = new int[w.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int length = preSum.length;
        int target = random.nextInt(preSum[length - 1]) + 1;
        return searchLeft(preSum, target) - 1;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
