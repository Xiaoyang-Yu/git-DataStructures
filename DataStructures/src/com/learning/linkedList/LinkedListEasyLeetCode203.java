package com.learning.linkedList;

public class LinkedListEasyLeetCode203 {

    public static void main(String[] args) {
        ListNode o7 = new ListNode(7,null);
        ListNode o6 = new ListNode(7,o7);
        ListNode o5 = new ListNode(7,o6);
        ListNode o4 = new ListNode(7,o5);
        ListNode o3 = new ListNode(6,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        //ListNode o1 = null;



        System.out.println(o1);
        ListNode lis = removeElements(o1,7);
        System.out.println(lis);
    }

    /**
     * 按照给定值，删除链表中的节点<br/>
     * 例如：<br/>
     * Input: head = [1,2,6,3,4,5,6], val = 6<br/>
     * Output: [1,2,3,4,5]<br/>
     * @param head -- 链表
     * @param val  --传来的值
     * @return  -- 新链表
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;  // 作为被删除节点的，前一个节点
        ListNode p2;

        while ((p2 = p1.next) != null){
            if (p2.val == val){
                p1.next = p2.next;
            }else {
                p1 = p1.next;   //没找到p1就往前一步
            }
        }
        return sentinel.next;
    }
}
