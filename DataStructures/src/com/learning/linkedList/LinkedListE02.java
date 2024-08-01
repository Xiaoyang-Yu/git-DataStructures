package com.learning.linkedList;


public class LinkedListE02 {

    public static void main(String[] args) {
        ListNode o7 = new ListNode(7, null);
        ListNode o6 = new ListNode(6, o7);
        ListNode o5 = new ListNode(5, o6);
        ListNode o4 = new ListNode(5, o5);
        ListNode o3 = new ListNode(2, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);

        System.out.println(o1);
        //removeDuplicationSelf(o1);
        System.out.println(removeDuplicationSelf(o1));
    }

    /**
     * 按照value删除节点
     */
    public static ListNode remove(ListNode head, int value){
        ListNode sentinel = new ListNode(666, head);  //哨兵，值随便，指针指向头
        //定义两个指针，一个从哨兵开始，一个从第一个元素开始
        ListNode p1 = sentinel;
        ListNode p2;
        //指针右移，找到对应的value
//        while (p2 != null){
//            if(p2.val == value){
//                //找到值，删除
//                p1.next = p2.next;
//                p2 = p1.next;   //应该是，始终保持p2 = p1.next 就是，p2始终在p1的后一个， 也就是说，所有的p2 都等于 p1.next
//            }else { //没找到，继续右移
//                p1 = p1.next;
//                p2 = p1.next;   //这里也是，所以可以简化成下面
//            }
//        }
        while ((p2 = p1.next) != null){
            if(p2.val == value){
                //找到值，删除
                p1.next = p2.next;
            }else { //没找到，继续右移
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

    /**
     * 删除·倒数·第n个节点
     * 双指针（快慢指针）
     * @return
     */
    public static ListNode removeLast(ListNode head, int n){
        ListNode sentinel = new ListNode(666, head);
        //定义两个指针，都指向sentinel
        ListNode p1 = sentinel;  //快指针
        ListNode p2 = sentinel;  //慢指针
        //1. 让快指针 p1 先向后移动n + 1次
        for (int i = 0; i < n; i++){
            p1 = p1.next;
        }
        //2. 两个指针容易后移， 直到p1.next 为空(这里如果是p1为空， 那么上面循环就要 i < n+1)
        //此时，p2指向的就是倒数第n个节点的  前一个节点
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //3. 删除节点
        p2.next = p2.next.next;
        //返回头节点
        return sentinel.next;
    }

    /**
     * 删除·有序· 链表的重复元素
     * - 双指针，同时后移，因为有序的链表，那么重复元素一定在一起
     */
    public static void removeDuplicate(ListNode p1){
        //当链表节点 < 2的时候
        if (p1 == null || p1.next == null){
            return;
        }
        //定义双指针 默认传进来的节点就是p1
        ListNode p2;
        while ((p2 = p1.next) != null){
            if (p1.val == p2.val){
                p1.next = p2.next;
            }else {
                p1 = p1.next;
            }
        }
    }

    /**
     * 删除·有序·链表的 所有重复元素，包含元素本身。
     * @return --
     */
    public static ListNode removeDuplicationSelf(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode sentinel = new ListNode(666, head);
        ListNode p1 = sentinel;   //表述重复元素的前一个节点
        ListNode p2,p3;
        while ((p2=p1.next) != null && (p3=p2.next) != null){
            if (p2.val == p3.val){
                while ((p3=p3.next) != null && (p3.val == p2.val)){} //p3往后移动，一直找到不重复值，退出循环
                //p3找到了不重复的值
                p1.next = p3;
            }else {
                p1 = p1.next;  //这里p1往后移动一会， p2和p3进入循环的时候，就自动跟着移动
            }
        }
        return sentinel.next;
    }
}
