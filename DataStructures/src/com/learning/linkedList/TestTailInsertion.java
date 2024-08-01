package com.learning.linkedList;

import java.util.Iterator;
import java.util.List;

public class TestTailInsertion{

    public static void main(String[] args) {


    }

    public static ListNode insertionTail(int val){
        //默认向空链表添加，所以开始的时候，链表中只存在一个节点，就是哨兵节点。
        //定义哨兵节点
        ListNode sentinel = new ListNode(666, null);
        //定义尾节点指针，这个指针每添加一次元素，都要向后移动一次，用来锁定尾节点
        ListNode tailPointer = sentinel;
        //尾节点指针指向新节点
        tailPointer.next = new ListNode(val, null);
        tailPointer = tailPointer.next;   //尾节点更新。
        return sentinel.next;
    }

}
