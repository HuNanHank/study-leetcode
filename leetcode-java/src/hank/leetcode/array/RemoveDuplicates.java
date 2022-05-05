package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/'>
 * <h2>Leetcode 26. 删除有序数组中的重复项</h2>
 * </a>
 * <p>
 * 给你一个升序排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致 。
 * <p>输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * <p>输出：5, nums = [0,1,2,3,4]
 * </p>
 * <h2>解题思路</h2>
 * 双指针
 *
 * @author hank
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));
    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[left - 2] != nums[right]) {
                nums[left++] = nums[right];
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

}
