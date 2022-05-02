package hank.leetcode.array;

import java.util.*;

/**
 * <a href ='https://leetcode-cn.com/problems/insert-delete-getrandom-o1/'>
 * <h2>Leetcode 380. O(1) 时间插入、删除和获取随机元素</h2>
 * </a>
 * <p>实现 RandomizedSet 类：
 * <p>RandomizedSet() 初始化 RandomizedSet 对象
 * <p>bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true。否则，返回 false。
 * <p>bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true。否则，返回 false。
 * <p>int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有相同的概率被返回。
 * <p>你必须实现类的所有函数，并满足每个函数的平均时间复杂度为O(1)。
 * <p>
 * <h2>解题思路</h2>
 * <a href ='https://labuladong.github.io/algo/2/18/30/'>常数时间删除/查找数组中的任意元素</a>
 * </p>
 *
 * @author hank
 */
public class RandomizedSet {
    private final List<Integer> values;
    private final Map<Integer, Integer> valueToIndex;
    private final Random random;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.valueToIndex = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        valueToIndex.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        int index = valueToIndex.get(val);
        int lastValue = values.get(values.size() - 1);

        // swap the elements to be deleted to the end of the array
        values.set(index, lastValue);
        valueToIndex.put(lastValue, index);

        // delete the trailing element
        valueToIndex.remove(val);
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
    }

}
