package hank.leetcode.list.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href ='https://leetcode-cn.com/problems/palindrome-linked-list/'>
 * <h2>Leetcode 234. 回文链表</h2>
 * </a>
 * <p>给你一个单链表的头节点head，请你判断该链表是否为回文链表。如果是，返回true；否则，返回false 。
 * <p>输入：head = [1,2,2,1]
 * <p>输出：true
 * <p>
 * <h2>解题思路</h2>
 * <p>1. 将链表复制到数组中再判断数组是否回文
 * <p>2. 反转后半段链表与前半段比较来判断回文
 * <p>
 * @author hank
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 2, 1});
        System.out.println(new Palindrome().isPalindrome0(list));
    }

    public boolean isPalindrome0(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }

        int left = 0;
        int right = list.size() - 1;
        boolean flag = true;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
    }
}
