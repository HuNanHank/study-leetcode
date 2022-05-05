package hank.leetcode.list.leetcode;

/**
 * <a href ='https://leetcode-cn.com/problems/merge-two-sorted-lists/'>
 * <h2>Leetcode 21. 合并两个有序链表</h2>
 * </a>
 * <p>将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>输入：list1 = [1,2,4], list2 = [1,3,4]
 * <p>输出：[1,1,2,3,4,4]
 * <p>
 * <h2>解题思路</h2>
 * <p>1. 递归
 * <p>2. 循环迭代
 * <p>
 *
 * @author hank
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode list1 = new ListNode();
        list1.createList(nums1);
        ListNode list2 = new ListNode();
        list2.createList(nums2);
        ListNode resultList = new MergeTwoLists().mergeTwoLists(list1, list2);
        System.out.println(resultList);
    }

    /**
     * 递归方式合并链表。（有待思考）
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 遍历两个链表比较节点大小，从小到大依次连接起来。
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode();
        ListNode pointerNode = resultList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointerNode.next = list1;
                list1 = list1.next;
            } else {
                pointerNode.next = list2;
                list2 = list2.next;
            }
            pointerNode = pointerNode.next;
        }
        pointerNode.next = (list1 == null) ? list2 : list1;
        return resultList.next;
    }
}
