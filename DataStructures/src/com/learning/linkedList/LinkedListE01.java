package com.learning.linkedList;


/**
 * 反转链表
 */
public class LinkedListE01 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);

        System.out.println(o1);
        ListNode newList = reverseList(o1);
        System.out.println(newList);


    }

    /**
     * 方法1
     * @param oldList --传进来的链表
     * @return --新链表
     */
    public static ListNode reverseList(ListNode oldList){
        ListNode newList = null; //新链表
        /*
         * 在链表操作中，传递给方法的链表变量通常是头节点，这是约定俗成的做法。
         * 传入的方法参数 oldList 被赋值给 p，因此 p 指向的是头节点 oldList。
         */
        //ListNode p = oldList;
        while (oldList != null){  //遍历oldList
            newList = new ListNode(oldList.val, newList);  //新链表的值， 指针指向新链表的头部
            oldList = oldList.next;
        }
        return newList;
    }

}
