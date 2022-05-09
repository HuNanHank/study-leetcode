package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/'>
 * <h2>Leetcode 19. 删除链表的倒数第 N 个结点</h2>
 * </a>
 * <p>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>输入：head = [1,2,3,4,5], n = 2
 * <p>输出：[1,2,3,5]
 * <p>
 * <h2>解题思路</h2>
 * <p>
 *
 * @author hank
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.createList(new int[]{1, 2, 3, 4, 5});
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(list, 3));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(-1, head);
        ListNode prePointer = tempHead;
        ListNode nextPointer = head;
        while (n-- > 0){
            nextPointer = nextPointer.next;
        }
        while (nextPointer != null){
            prePointer = prePointer.next;
            nextPointer = nextPointer.next;
        }
        prePointer.next = prePointer.next.next;
        head = tempHead.next;
        return head;
    }
}
