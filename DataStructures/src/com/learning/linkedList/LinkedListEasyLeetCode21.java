package com.learning.linkedList;

public class LinkedListEasyLeetCode21 {

    public static void main(String[] args) {
        ListNode o3 = new ListNode(4,null);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        ListNode nullList = null;
        //----
        ListNode oo3 = new ListNode(4,null);
        ListNode oo2 = new ListNode(3,oo3);
        ListNode oo1 = new ListNode(1,oo2);
        ListNode nullList1 = null;

        System.out.println(mergeTwoLists(o1, oo1));
    }

    /**
     * 给出了两个已排序链表的头list1和list2。<br/>
     * 将两个列表合并为一个排序列表。该列表应通过将前两个列表的节点拼接在一起而制成。<br/>
     * 返回合并链表的头。<br/>
     * 例如：<br/>
     * 输入： list1 = [1,2,4], list2 = [1,3,4]<br/>
     * 输出： [1,1,2,3,4,4]<br/>
     * @param p1 --
     * @param p2 --  双指针
     * @return --返回哨兵的下个节点
     */
    public static ListNode mergeTwoLists(ListNode p1, ListNode p2) {   //双指针
        ListNode sentinel = new ListNode(666, null); // 哨兵
        ListNode n = sentinel;   //新链表
        while (p1 !=null && p2 != null){
            if (p1.val < p2.val){
                n.next = p1;
                p1 = p1.next;
            }else {
                n.next = p2;
                p2 = p2.next;
            }
            n = n.next;    //新链表指针后移
        }
        if (p1 == null){   //为空的时候，返回另一个链表
            n.next = p2;
        }
        if (p2 == null){
            n.next = p1;
        }
        return sentinel.next;   //返回哨兵的下一个节点
    }
}
