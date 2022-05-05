package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/'>
 * <h2>Leetcode 83. 删除排序链表中的重复元素</h2>
 * </a>
 * <p>给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回已排序的链表。
 * <p>输入：head = [1,1,2,3,3]
 * <p>输出：[1,2,3]
 * <p>
 * <h2>解题思路</h2>
 * <p>遍历链表比较前后节点是否相等，若相等移除前一个节点。
 * <p>
 *
 * @author hank
 */
public class DeleteDuplicates {
    public void deleteDuplicates(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3};
        ListNode list = new ListNode();
        list.createList(nums);
        System.out.println(list);
        new DeleteDuplicates().deleteDuplicates(list);
        System.out.println(list);
    }
}
