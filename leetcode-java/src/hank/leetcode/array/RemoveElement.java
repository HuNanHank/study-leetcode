package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/remove-element/'>
 * <h2>Leetcode 27. 移除元素</h2>
 * </a>
 * <p>
 * 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>输入：nums = [3,2,2,3], val = 3
 * <p>输出：2, nums = [2,2]
 * </p>
 * <h2>解题思路</h2>
 * 双指针
 *
 * @author hank
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int length = new RemoveElement().removeElement(nums, val);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));
    }

    /**
     * 双向指针
     */
    public int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            if (nums[low] == val) {
                nums[low] = nums[high - 1];
                high--;
            } else {
                low++;
            }
        }
        return low;
    }

    /**
     * 快慢指针
     */
    public int removeElement0(int[] nums, int val) {
        int n = nums.length;
        int low = 0;
        for (int high = 0; high < n; high++) {
            if (nums[high] != val) {
                nums[low] = nums[high];
                low++;
            }
        }
        return low;
    }
}
