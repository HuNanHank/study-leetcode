package hank.leetcode.array.binarysearch;

/**
 * <a href ='https://leetcode-cn.com/problems/koko-eating-bananas/'><h2>Leetcode 875. 爱吃香蕉的珂珂</h2></a>
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * </p>
 * <p>输入：piles = [3,6,7,11], h = 8
 * <p>输出：4
 * <p>
 * <h2>解题思路</h2>
 * <a href ='https://labuladong.github.io/algo/2/18/28/'>爱吃香蕉的珂珂</a>
 * </p>
 *
 * @author hank
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int speed = (low + high) >>> 1;
            if (canEated(piles, speed, h)) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return low;
    }

    private boolean canEated(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            // 向上取整的算法，有点难理解
            hours += (pile + speed - 1) / speed;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        System.out.println(new MinEatingSpeed().minEatingSpeed(piles, h));
    }
}
