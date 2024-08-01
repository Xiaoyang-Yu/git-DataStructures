package com.learning.linkedList;

public class LinkedListEasyLeetCode234 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(1,null);
        ListNode o4 = new ListNode(2,o5);
        //ListNode o3 = new ListNode(3,o4);
        //ListNode o2 = new ListNode(3,o3);
        ListNode o11 = new ListNode(2,o4);
        ListNode o1 = new ListNode(1,o11);

        System.out.println(o1);
        System.out.println(isPalindrome(o1));
    }


    /**
     * 判断是否是回文链表Palindrome  <br/>
     * 回文链表： 1 -> 2 -> 2 -> 1 从前往后，或者从后往前看都一样<br/>
     *  1 -> 2 -> 3 -> 2 -> 1
     * @param head --
     * @return -- 返回true or false
     */
    public static boolean isPalindrome(ListNode head){
        //1. 找到中间点，并反转前半部分链表
        ListNode p1 = head;  //快指针
        ListNode p2 = head;  //慢指针
        ListNode revList = null;
        while (p1 != null && p1.next != null){
            revList = new ListNode(p2.val, revList);
            p1 = p1.next.next;
            p2 = p2.next;
        }
        //如果是奇数个，链表的前半部分当中，不包含中间直接，所以要额外赋值
        if (p1 != null){
            revList = new ListNode(p2.val, revList);
        }
        //比较
        while (revList != null){
            if (revList.val != p2.val){
                return false;
            }
            p2 = p2.next;
            revList = revList.next;
        }
        return true;
    }

}
/**
 *        //1. 找到中间点，并且反转 前半部分链表。
 *         ListNode p1 = head; //快指针
 *         ListNode p2 = head; //慢指针
 *         ListNode newList = null; //用于反转
 *         while (p1 != null && p1.next != null){
 *             //反转
 *             newList = new ListNode(p2.val, newList);
 *             //找到中间节点
 *             p1 = p1.next.next;
 *             p2 = p2.next;
 *
 *         }
 *         if (p1 != null){   //判断一下，如果循环出来此时，快指针指向的不是null，说明是奇数个节点的链表，把中间节点加进去。
 *             newList = new ListNode(p2.val, newList);
 *         }
 *         System.out.println(newList);
 *         while (newList != null && newList.next != null){
 *             if (newList.val != p2.val){
 *                 return false;
 *             }
 *             newList = newList.next;
 *             p2 = p2.next;
 *         }
 *         return true;
 */
