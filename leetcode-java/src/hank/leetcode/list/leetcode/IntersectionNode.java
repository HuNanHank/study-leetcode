package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/intersection-of-two-linked-lists/'>
 * <h2>Leetcode 160. 相交链表</h2>
 * </a>
 * <p>给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null。
 * <p>输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * <p>输出：Intersected at '8'
 * <p>
 * <h2>解题思路</h2>
 * <p>1. 暴力穷举
 * <p>2. 在暴力穷举的基础上引入HashMap
 * <p>3. 双指针
 * <p>
 *
 * @author hank
 */
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode listA = new ListNode();
        listA.createList(new int[]{4, 1, 8, 4, 5});
        ListNode listB = new ListNode();
        listB.createList(new int[]{5, 6, 1});
        listB.next.next.next = listA.next.next;
        System.out.println(new IntersectionNode().getIntersectionNode(listA, listB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pHeadA = headA;
        ListNode pHeadB = headB;

        while (pHeadA != pHeadB) {
            pHeadA = pHeadA == null ? headB : pHeadA.next;
            pHeadB = pHeadB == null ? headA : pHeadB.next;
        }
        return pHeadA;
    }
}
