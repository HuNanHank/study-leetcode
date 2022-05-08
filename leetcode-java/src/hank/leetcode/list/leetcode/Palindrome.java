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
 *
 * @author hank
 */
public class Palindrome {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 2, 1});
        System.out.println(new Palindrome().isPalindrome(list));
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

    public boolean isPalindrome(ListNode head) {
        ListNode lowPointer = head;
        ListNode highPointer = head;
        // 使用快慢指针找出链表的后半段链表的头节点
        while (highPointer != null && highPointer.next != null) {
            lowPointer = lowPointer.next;
            highPointer = highPointer.next.next;
        }
        // 如果链表节点个数为奇数，那么后半段头节点还要向前移动一个
        if (highPointer != null) {
            lowPointer = lowPointer.next;
        }

        ListNode firstHalfPointer = head;
        // 获取后半段链表反转后的头节点
        ListNode secondHalfPointer = reverseList(lowPointer);
        boolean isPalindrome = true;

        // 循环比较前后半段链表的值是否相等（这里的判断循环结束要以后半段链表为准）
        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                isPalindrome = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curPointer = head;
        ListNode prePointer = null;

        while (curPointer != null) {
            ListNode nextPointer = curPointer.next;
            curPointer.next = prePointer;
            prePointer = curPointer;
            curPointer = nextPointer;
        }
        return prePointer;
    }

}
