package com.learning.linkedList;

public class LinkedListEasyLeetCode141 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o11 = new ListNode(1,o2);
        ListNode o1 = new ListNode(1,o11);

        o5.next = o11;

        //System.out.println(o1);
        System.out.println(hasCycle(o1));

    }

    /**
     * 给定head一个链表的头，确定该链表中是否存在循环。<br/>
     * 如果链表中有某个节点可以通过连续跟随指针再次到达 next ，则链表中存在循环。<br/>
     * 在内部，pos 用于表示 tail next 指针所连接的节点的索引。 请注意， pos 不作为参数传递。<br/>
     * @param head --
     * @return -- true如果链表有循环则返回 ，否则返回false。
     */
    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head; //快
        ListNode p2 = head; //慢

        while (p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }
}
