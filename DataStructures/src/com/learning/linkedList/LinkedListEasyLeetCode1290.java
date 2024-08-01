package com.learning.linkedList;


public class LinkedListEasyLeetCode1290 {

    public static void main(String[] args) {
        //[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
        ListNode o15 = new ListNode(0,null);
        ListNode o14 = new ListNode(0,o15);
        ListNode o13 = new ListNode(0,o14);
        ListNode o12 = new ListNode(0,o13);
        ListNode o11 = new ListNode(0,o12);
        ListNode o10 = new ListNode(0,o11);
        ListNode o9 = new ListNode(1,o10);
        ListNode o8 = new ListNode(1,o9);
        ListNode o7 = new ListNode(1,o8);
        ListNode o6 = new ListNode(0,o7);
        ListNode o5 = new ListNode(0,o6);
        ListNode o4 = new ListNode(1,o5);
        ListNode o3 = new ListNode(0,o4);
        ListNode o2 = new ListNode(0,o3);
        ListNode o1 = new ListNode(1,o2);


//        ListNode oa = new ListNode(1,null);
//        ListNode ob = new ListNode(0,oa);
//        ListNode oc = new ListNode(1,ob);
        int value = getDecimalValue(o1);
        System.out.println(o1);
        System.out.println(value);

    }


    /**
     * 把链表中2进制的值，转换成10进制  <br/>
     * 例如：<br/>
     * Input: head = [1,0,1]<br/>
     * Output: 5<br/>
     * Explanation: (101) in base 2 = (5) in base 10<br/>
     * @param head --传进来的链表
     * @return --返回结果
     */
    public static int getDecimalValue(ListNode head){

        int p = 0;
        int sum = 0;
        ListNode pointer = head;
        //先把指针挪到最后， 得到一共多少个节点，计算一共是2^p
        while (pointer.next != null){
            pointer = pointer.next;
            p++;
        }
        //[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]   二进制应该从后往前看，最后一位是2^0
        while (head != null){
            if (head.val == 1){
                int v = (int)Math.pow(2, p);
                sum = sum + v;
            }
            p--;
            head = head.next;
        }
        return sum;
    }
}
