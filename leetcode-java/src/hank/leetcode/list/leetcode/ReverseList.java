package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/reverse-linked-list/'>
 * <h2>Leetcode 206. 反转链表</h2>
 * </a>
 * <p>给你单链表的头节点head，请你反转链表，并返回反转后的链表。
 * <p>输入：head = [1,2,3,4,5]
 * <p>输出：[5,4,3,2,1]
 * <p>
 *
 * @author hank
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseList().reverseList(list));
    }

    public ListNode reverseList(ListNode head) {
        ListNode curPointer = head;
        // 翻转后的链表的前一个节点，不是原链表的前一个节点
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
