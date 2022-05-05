package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/squares-of-a-sorted-array/'>
 * <h2>Leetcode 977.有序数组的平方</h2>
 * </a>
 * <p>
 * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>输入：nums = [-4,-1,0,3,10]
 * <p>输出：[0,1,9,16,100]
 * </p>
 * <h2>解题思路</h2>
 * 双指针
 *
 * @author hank
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int[] squareNums = new int[length];
        int index = high;
        while (index >= 0) {
            if (Math.abs(nums[low]) < Math.abs(nums[high])) {
                squareNums[index] = nums[high] * nums[high];
                high--;
            } else {
                squareNums[index] = nums[low] * nums[low];
                low++;
            }
            index--;
        }
        return squareNums;
    }
}
