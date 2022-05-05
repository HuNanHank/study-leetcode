package hank.leetcode.array;

/**
 * <a href ='https://leetcode-cn.com/problems/subarray-sum-equals-k/'>
 * <h2>Leetcode 560. 和为 K 的子数组</h2>
 * </a>
 * <p>
 * 给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的子数组的个数 。
 * <p>输入：nums = [1,1,1], k = 2
 * <p>输出：2
 * </p>
 * <h2>解题思路</h2>
 * <a href='https://labuladong.github.io/algo/2/18/21/'>前缀和数组算法</a>
 *
 * @author hank
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new SubarraySum().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
