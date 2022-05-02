package hank.leetcode.array.slidingwindow;

import java.util.HashSet;

/**
 * <a href ='https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/'><h2>Leetcode 3. 无重复字符的最长子串</h2></a>
 * <p>
 * 给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。
 * </p>
 * <p>输入：s = "abcabcbb"
 * <p>输出：3
 * <p>
 * <h2>解题思路</h2>
 * <a href ='https://labuladong.github.io/algo/2/18/25/'>无重复字符的最长子串</a>
 *
 * @author hank
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<String> set = new HashSet<>();
        while (right < s.length()) {
            while (set.contains(String.valueOf(s.charAt(right)))) {
                max = Math.max(max, right - left);
                set.remove(String.valueOf(s.charAt(left)));
                left++;
            }
            set.add(String.valueOf(s.charAt(right)));
            right++;
        }
        return Math.max(max, set.size());
    }
}
