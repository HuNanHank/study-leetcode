package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/middle-of-the-linked-list/'>
 * <h2>Leetcode 876. 链表的中间结点</h2>
 * </a>
 * <p>给定一个头结点为head的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * <p>输入：head = [1,2,3,4,5]
 * <p>输出：[3,4,5]
 * <p>
 * <h2>解题思路</h2>
 * <p>快慢指针
 * <p>
 *
 * @author hank
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println(new MiddleNode().middleNode(list));
    }

    public ListNode middleNode(ListNode head) {
        ListNode lowPointer = head;
        ListNode highPointer = head;
        while (highPointer != null && highPointer.next != null) {
            lowPointer = lowPointer.next;
            highPointer = highPointer.next.next;
        }
        return lowPointer;
    }
}
