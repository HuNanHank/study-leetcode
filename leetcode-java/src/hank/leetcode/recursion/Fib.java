package hank.leetcode.recursion;

/**
 * <a href ='https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/'>
 * <h2>剑指 Offer 10- I. 斐波那契数列</h2>
 * </a>
 * <p>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * </p>
 * <p>输入：n = 3
 * <p>输出：2
 * <h2>解题思路</h2>
 * 递归算法
 *
 * @author hank
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(new Fib().fib(3));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int preValue = 1;
        int beforePreValue = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (preValue + beforePreValue) % 1000000007;
            beforePreValue = preValue;
            preValue = result;
        }
        return result;
    }

    public int fib0(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib0(n - 1) + fib0(n - 2);
    }

}
