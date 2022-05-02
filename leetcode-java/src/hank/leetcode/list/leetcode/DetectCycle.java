package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/linked-list-cycle-ii/'>
 * <h2>Leetcode 142. 环形链表II</h2>
 * </a>
 * <p>给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>输入：head = [3,2,0,-4], pos = 1 （链表中有一个环，其尾部连接到第二个节点。）
 * <p>输出：返回索引为1的链表节点
 * <p>
 * <h2>解题思路</h2>
 * <p><a href='https://labuladong.github.io/algo/2/17/16/'>Floyd判圈算法推论</a>
 * <p>
 *
 * @author hank
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowNode = head, fastNode = head;
        boolean hasCycle = false;

        // find the metting node
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }

        // if the linked list has a cycle, next find the entry node
        if (hasCycle) {
            ListNode tempNdoe = head;
            while (tempNdoe != fastNode) {
                tempNdoe = tempNdoe.next;
                fastNode = fastNode.next;
            }
            return tempNdoe;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.insertTail(2);
        list.insertTail(0);
        list.insertTail(-4);
        System.out.println(list);
        list.next.next.next = list.next;
        System.out.println(new DetectCycle().detectCycle(list).val);
    }
}
