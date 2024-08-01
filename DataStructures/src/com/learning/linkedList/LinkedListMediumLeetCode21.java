package com.learning.linkedList;

public class LinkedListMediumLeetCode21 {

    public static void main(String[] args) {
        ListNode o8 = new ListNode(0,null);
        ListNode o7 = new ListNode(2,o8);
        ListNode o6 = new ListNode(5,o7);
        ListNode o5 = new ListNode(4,o6);
        ListNode o4 = new ListNode(0,o5);
        ListNode o3 = new ListNode(1,o4);
        ListNode o2 = new ListNode(3,o3);
        ListNode o1 = new ListNode(0,o2);

        System.out.println(o1);
        ListNode lis = mergeNodes(o1);
        System.out.println(lis);
    }

    /**
     * 给定一个链表的 head，其中包含一系列以分隔的0整数。链表的开头和结尾的值都 = 0。<br/>
     * 对于每两个连续的0，将它们之间的所有节点合并为一个节点，该节点的值是所有合并节点的总和。修改后的列表不应包含任何0。<br/>
     * 返回修改后的链表的 。head <br/>
     * 例如：<br/>
     * 输入： head = [0,3,1,0,4,5,2,0]<br/>
     * 输出： [4,11]<br/>
     * @param head -- 链表头节点
     * @return  -- 新链表
     */
    public static ListNode mergeNodes(ListNode head) {
        ListNode sentinel = new ListNode(777, null);
        ListNode tailNode = sentinel;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head.next;  //指针可以从第二个节点开始
        int temp = 0;
        while (p != null){
            if (p.val != 0){   //值等于0的时候， 计算总和
                temp += p.val;
            }else {           //当不等于0的时候， 把计算的综合添加到链表中，然后重置temp，指针后移。
                tailNode.next = new ListNode(temp, null);
                temp = 0;
                tailNode = tailNode.next;
            }
            p = p.next;
        }
        return sentinel.next;
    }
}
