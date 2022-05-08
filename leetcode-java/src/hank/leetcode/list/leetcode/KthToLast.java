package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/'>
 * <h2>Leetcode 返回倒数第k个节点</h2>
 * </a>
 * <p>实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>输入：head = [1,2,3,4,5]  k = 2
 * <p>输出：4
 * <p>
 * <h2>解题思路</h2>
 * <p>1. 反转链表后遍历
 * <p>2. 快慢双指针
 * <p>
 *
 * @author hank
 */
public class KthToLast {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println(new KthToLast().kthToLast(list, 1));
    }

    public int kthToLast(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return -1;
        }

        ListNode lowPointer = head;
        ListNode highPointer = head;
        while (k-- > 0) {
            highPointer = highPointer.next;
        }

        while (highPointer != null) {
            lowPointer = lowPointer.next;
            highPointer = highPointer.next;
        }

        return lowPointer.val;
    }

    public int kthToLast0(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return -1;
        }

        ListNode reversedList = reverseList(head);
        while (--k > 0) {
            reversedList = reversedList.next;
        }
        return reversedList.val;
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
