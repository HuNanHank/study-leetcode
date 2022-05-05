package hank.leetcode.array;

import java.util.Arrays;

/**
 * <a href ='https://leetcode-cn.com/problems/corporate-flight-bookings/'><h2>Leetcode 1109. 航班预订统计</h2></a>
 * <p>
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从firsti到lasti（包含firsti和lasti）的每个航班上预订了seatsi个座位。
 * 请你返回一个长度为n的数组answer，里面的元素是每个航班预定的座位总数。
 * </p>
 * <p>输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * <p>输出：[10,55,45,25,25]
 * <p>
 * <h2>解题思路</h2>
 * <a href ='https://labuladong.github.io/algo/2/18/22/'>差分数组</a>
 *
 * @author hank
 */
public class CorpFlightBookings {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(new CorpFlightBookings().corpFlightBookings2(bookings, n)));
    }

    /**
     * 暴力算法。
     *
     * @param bookings 航班预订表
     * @param n        航班数
     * @return 每个航班预定的座位总数
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int first;
        int last;
        int seats;
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            first = booking[0] - 1;
            last = booking[1] - 1;
            seats = booking[2];
            for (int j = first; j <= last; j++) {
                answer[j] += seats;
            }
        }
        return answer;
    }

    /**
     * 差分数组算法。
     *
     * @param bookings 航班预订表
     * @param n        航班数
     * @return 每个航班预定的座位总数
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] diff = new int[n];
        int[] answer = new int[n];
        int first;
        int last;
        int seats;
        for (int[] booking : bookings) {
            first = booking[0];
            last = booking[1];
            seats = booking[2];
            diff[first - 1] += seats;
            if (last < n) {
                diff[last] -= seats;
            }
        }
        answer[0] = diff[0];
        for (int i = 1; i < n; i++) {
            answer[i] = diff[i] + answer[i - 1];
        }
        return answer;
    }

    /**
     * 优化版差分数组算法。
     *
     * @param bookings 航班预订表
     * @param n        航班数
     * @return 每个航班预定的座位总数
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                answer[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i] + answer[i - 1];
        }
        return answer;
    }
}
