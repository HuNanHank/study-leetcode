package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/merge-sorted-array/'>
 * <h2>Leetcode 88. 合并两个有序数组</h2>
 * </a>
 * <p>
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * </p>
 * <p>输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>输出：[1,2,2,3,5,6]
 * <p>
 * <h2>解题思路</h2>
 * 双指针
 *
 * @author hank
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        new MergeArray().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int index = nums1.length - 1, indexm = m - 1, indexn = n - 1; index >= 0; index--) {
            if (indexm >= 0 && indexn >= 0) {
                if (nums1[indexm] > nums2[indexn]) {
                    nums1[index] = nums1[indexm--];
                } else {
                    nums1[index] = nums2[indexn--];
                }
            } else {
                if (indexn >= 0) {
                    nums1[index] = nums2[indexn--];
                }
            }
        }
    }
}
