package hank.leetcode.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href ='https://leetcode-cn.com/problems/fruit-into-baskets/'><h2>Leetcode 904. 水果成篮</h2></a>
 *
 * @author hank
 */
public class TotalFruit {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(new TotalFruit().totalFruit(fruits));
    }
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int max = 0;
        int basketSize = 2;
        Map<Integer, Integer> totalMap = new HashMap<>(basketSize);
        while (right < fruits.length) {
            totalMap.put(fruits[right], totalMap.getOrDefault(fruits[right], 0) + 1);
            while (totalMap.size() > basketSize) {
                totalMap.put(fruits[left], totalMap.get(fruits[left]) - 1);
                if (totalMap.get(fruits[left]) == 0) {
                    totalMap.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
