package hank.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href ='https://leetcode-cn.com/problems/two-sum/'>
 * <h2>Leetcode 1. 两数之和</h2>
 * </a>
 * <p>
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * </p>
 * <p>输入：nums = [2,7,11,15], target = 9
 * <p>输出：[0,1]
 * <h2>解题思路</h2>
 * Hash表
 *
 * @author hank
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
