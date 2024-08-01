package com.learning.linkedList;

public class LinkedListEasyLeetCode206 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);

        System.out.println(o1);
        ListNode list = reverseList2(o1);
        System.out.println(list);
    }

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.<br/>
     * Input: head = [1,2,3,4,5]<br/>
     * Output: [5,4,3,2,1]<br/>
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode last = reverseList(head.next); //找到最后一个节点, 通过head.next找到的最后一个节点，此时head就是倒数第二个节点
        head.next.next = head;   // head.next 表示最后一个节点，再.next表示 这个节点指向的是 = head
        head.next = null;

        return last;
    }
    //第二种方法
    public static ListNode reverseList2(ListNode head){
        ListNode ln = null;

        while (head != null){
            ln = new ListNode(head.val, ln);
            head = head.next;
        }
        return ln;
    }

}
