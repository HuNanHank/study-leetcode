package hank.leetcode.array.binarysearch;

/**
 * <a href ='https://leetcode-cn.com/problems/binary-search/'><h2>Leetcode 704.二分查找</h2></a>
 * <p>
 * 给定一个n个元素有序的（升序）整型数组nums和一个目标值target。
 * 写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回 -1。
 * </p>
 * <p>输入：nums = [-1,0,3,5,9,12], target = 9
 * <p>输出：4
 * <p>
 * <h2>解题思路</h2>
 * <p>
 * <b>每当我们遇到一个问题的时候，首先我们应该最能想到的是使用暴力的方式去解决问题。
 * 然后我们再在暴力的解决方案上寻求优化手段，进而以更加有效的方式解决问题。</b>
 * </p>
 * <p>
 * 在这个问题上,我们可以使用暴力的解法，遍历整个数组，找到目标值。
 * 但是问题中给出的数组是有序的，那么我们就可以使用大名顶顶二分查找算法来解决这个问题。
 * </p>
 *
 * @author hank
 */
public class BinarySearch {

    public int search1(int[] nums, int target) {
        int left = 0;
        // 这里如果right = nums.length - 1 那么下面循环结束的判定条件就是 left <= right
        int right = nums.length - 1;
        if (target < nums[0] || target > nums[right]) {
            return -1;
        }
        while (left <= right) {
            //int mid = (left + right) / 2; // 这里不推荐使用 (left + right) / 2 因为可能出现left、right过大造成 left + right 溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        // 这里如果right = nums.length 那么下面循环结束的判定条件就是 left < right
        int right = nums.length;
        if (target < nums[0] || target > nums[right - 1]) {
            return -1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 这种情况下不要忽略nums[left] = nums[right] = target的情况
        return nums[left] == target ? left : -1;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[0] || target > nums[right]) {
            return -1;
        }
        while (left <= right) {
            // JDK的实现：使用位运算居然可以避免溢出而且移位运算比除法运算要快
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(new BinarySearch().search(nums, target));
        System.out.println(new BinarySearch().search1(nums, target));
        System.out.println(new BinarySearch().search2(nums, target));
    }
}
