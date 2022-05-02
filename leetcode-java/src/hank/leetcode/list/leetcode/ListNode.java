package hank.leetcode.list.leetcode;

/**
 * Leetcode的链表结构实现
 *
 * @author hank
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * 向链表的尾部插入数据。
     *
     * @param val 数据值
     */
    public void insertTail(int val) {
        ListNode tempNode = new ListNode(val);
        ListNode pointerNode = this;
        while (pointerNode.next != null) {
            pointerNode = pointerNode.next;
        }
        pointerNode.next = tempNode;
    }

    /**
     * 根据数组值创建链表（链表无头节点）。
     *
     * @param values 数组值
     */
    public void createList(int[] values) {
        this.val = values[0];
        ListNode pointerNode = this;
        for (int i = 1; i < values.length; i++) {
            pointerNode.next = new ListNode(values[i]);
            pointerNode = pointerNode.next;
        }
    }

    /**
     * 将链表值按顺序拼接成字符串返回。
     *
     * @return 结果字符串
     */
    @Override
    public String toString() {
        ListNode pointerNode = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (pointerNode != null) {
            stringBuilder.append(pointerNode.val).append(", ");
            pointerNode = pointerNode.next;
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
