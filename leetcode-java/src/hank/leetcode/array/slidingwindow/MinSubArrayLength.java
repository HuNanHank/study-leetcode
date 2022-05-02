package hank.leetcode.array.slidingwindow;

/**
 * <a href ='https://leetcode-cn.com/problems/minimum-size-subarray-sum/'><h2>Leetcode 209. 长度最小的子数组</h2></a>
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数target。找出该数组中满足其和 >= target的长度最小的连续子数组
 * [numsl,numsl+1,...,numsr-1,numsr]，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * </p>
 * <p>输入：target = 7, nums = [2,3,1,2,4,3]
 * <p>输出：2
 *
 * @author hank
 */
public class MinSubArrayLength {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new MinSubArrayLength().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
