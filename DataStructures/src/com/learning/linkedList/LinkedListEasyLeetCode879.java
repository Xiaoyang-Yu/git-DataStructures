package com.learning.linkedList;

public class LinkedListEasyLeetCode879 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        //ListNode o11 = new ListNode(1,o2);
        //ListNode o1 = new ListNode(1,o2);

        System.out.println(o2);
        ListNode middleNode = middleNode(o2);
        System.out.println(middleNode);
    }

    /**
     * Given the head of a singly linked list, return the middle node of the linked list.<br/>
     * If there are two middle nodes, return the second middle node.<br/>
     * 双指针法: p1慢指针 一次移动1步， p2快指针 一次移动2步， 当p2 == null的时候， p1指向的正好是mid节点
     * @param head -- 传进来的链表
     * @return --中间节点，如果是双数的，返回第二个中间节点
     */
    public static ListNode middleNode(ListNode head){
        ListNode p1 = head;
        ListNode p2 = p1;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
