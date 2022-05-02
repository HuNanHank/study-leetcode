package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/move-zeroes/'>
 * <h2>Leetcode 283. 移动零</h2>
 * </a>
 * <p>
 * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * </p>
 * <p>输入：nums = [0,1,0,3,12]
 * <p>输出：[1,3,12,0,0]
 * <p>
 * <h2>解题思路</h2>
 * 直接遍历交换零元素
 *
 * @author hank
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes0(int[] nums) {
        for (int i = 0, nonZero = 1; nonZero < nums.length; ) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[nonZero] != 0) {
                nums[i] = nums[nonZero];
                nums[nonZero] = 0;
                i++;
            }
            nonZero++;
        }
    }
}
