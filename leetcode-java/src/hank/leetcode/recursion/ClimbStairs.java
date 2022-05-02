package hank.leetcode.recursion;

import java.util.HashMap;

/**
 * <a href ='https://leetcode-cn.com/problems/climbing-stairs/'>
 * <h2>Leetcode 70. 爬楼梯</h2>
 * </a>
 * <p>
 * 假设你正在爬楼梯。需要n阶你才能到达楼顶。每次你可以爬1或2个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * </p>
 * <p>输入：n = 3
 * <p>输出：3
 * <h2>解题思路</h2>
 * 递归算法
 *
 * @author hank
 */
public class ClimbStairs {
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new ClimbStairs().climbStairs(n));
    }

    public int climbStairs0(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int midValue = climbStairs0(n - 1) + climbStairs0(n - 2);
            map.put(n, midValue);
            return midValue;
        }
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int preValue = 2;
        int beforePreValue = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = preValue + beforePreValue;
            beforePreValue = preValue;
            preValue = result;
        }
        return result;
    }

}
