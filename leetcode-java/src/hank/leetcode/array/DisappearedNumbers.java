package hank.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href ='https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/'>
 * <h2>Leetcode 448. 找到所有数组中消失的数字</h2>
 * </a>
 * <p>
 * 给你一个含n个整数的数组nums，其中nums[i]在区间[1,n]内。请你找出所有在[1,n]范围内但没有出现在nums中的数字，并以数组的形式返回结果。
 * </p>
 * <p>输入：nums = [4,3,2,7,8,2,3,1]
 * <p>输出：[5,6]
 * <p>
 * <h2>解题思路</h2>
 * 快慢指针
 *
 * @author hank
 */
public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new DisappearedNumbers().findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                nums[temp] = -nums[temp];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
