package hank.leetcode.array.binarysearch;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/'><h2>Leetcode 34. 在排序数组中查找元素的第一个和最后一个位置</h2></a>
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * </p>
 * <p>输入：nums = [5,7,7,8,8,10], target = 8</p>
 * <p>输出：[3,4]</p>
 * <p>
 * <h2>解题思路</h2>
 * <p>
 * 在看到这个问题的时候，我最先想到的是先用二分查找找出一个目标值，然后在从目标值位置的两边去寻找目标值的开始位置和结束位置。
 * </p>
 * <p>
 * 这种解法虽然可行但是感觉不太优雅。那么能不能在二分查找的过程中去找到目标位置。所以就衍生出了二分查找算法的变形算法。
 * 这是查找有多个目标值的情况下，目标值的边界值。
 * <ul>
 *     <li>查找目标值的左边界</li>
 *     <li>查找目标值的右边界</li>
 * </ul>
 * </p>
 *
 * @author hank
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {1, 4, 8, 10, 14};
        int target = 9;
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, target)));
    }

    /**
     * 查找目标值的左边界
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 目标值的左边界
     */
    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
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
        // 检查目标值不存在的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 查找目标值的右边界
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 目标值的右边界
     */
    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 检查目标值不存在的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    /**
     * 比较土的算法
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 目标值的范围
     */
    public int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > right) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        for (int i = left; i <= mid; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        for (int i = right; i >= mid; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
