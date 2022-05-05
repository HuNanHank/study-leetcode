package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/linked-list-cycle/'>
 * <h2>Leetcode 141. 环形链表</h2>
 * </a>
 * <p>给你一个链表的头节点head，判断链表中是否有环。
 * <p>输入：head = [3,2,0,-4], pos = 1 （链表中有一个环，其尾部连接到第二个节点。）
 * <p>输出：true
 * <p>
 * <h2>解题思路</h2>
 * <p>Floyd判圈算法
 * <p>
 *
 * @author hank
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.insertTail(2);
        list.insertTail(0);
        list.insertTail(-4);
        System.out.println(list);
        list.next.next.next = list.next;
        System.out.println(new HasCycle().hasCycle(list));
    }

    /**
     * Floyd判圈算法：使用两个指针slow、fast，其中slow每次移动一个节点，fast每次移动两个节点。
     * 若有环则slow最终会和fast相交于同一个节点。
     *
     * @param head 目标链表
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (slowNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }
}
