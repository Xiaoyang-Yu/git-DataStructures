package com.learning.linkedList;

public class LinkedListEasyLeetCode83 {

    public static void main(String[] args) {

        ListNode o5 = new ListNode(3,null);
        ListNode o4 = new ListNode(3,o5);
        ListNode o3 = new ListNode(2,o4);
        ListNode o2 = new ListNode(1,o3);
        ListNode o1 = new ListNode(1,o2);
        ListNode on = null;


        System.out.println(o1);
        ListNode lis = deleteDuplicates(o1);
        System.out.println(lis);
    }

    /**
     * 删除有序链表的重复元素，留下一个<br/>
     * Input: head = [1,1,2]<br/>
     * Output: [1,2]<br/>
     * @param head -- 链表头
     * @return --返回链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){  //当节点 <2的时候，直接返回
            return head;
        }
        ListNode p1 = head;  //双指针同时移动。
        ListNode p2;
        while ((p2 = p1.next) != null){
            if (p1.val == p2.val){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
        }
        return head;
    }
}
