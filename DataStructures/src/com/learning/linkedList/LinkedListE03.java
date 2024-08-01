package com.learning.linkedList;

import org.junit.jupiter.api.Test;

public class LinkedListE03 {

    public static void main(String[] args) {
//        ListNode o7 = new ListNode(7, null);
//        ListNode o6 = new ListNode(6, o7);
//        ListNode o5 = new ListNode(5, o6);
//        ListNode o4 = new ListNode(5, o5);
//        ListNode o3 = new ListNode(2, o4);
//
//        ListNode oa = new ListNode(11, null);
//        ListNode ob = new ListNode(9, oa);
//        ListNode oc = new ListNode(8, ob);
//        ListNode od = new ListNode(5, oc);
//        ListNode oe = new ListNode(2, od);
//
//        ListNode empty = null;
//        System.out.println(o3);
//        System.out.println(oe);
//        System.out.println(mergeListAll(o3, oe));

    }
    @Test
    public void testMergeKList(){
        ListNode o7 = new ListNode(5, null);
        ListNode o6 = new ListNode(4, o7);
        ListNode o5 = new ListNode(1, o6);
        //------------------------------------------
        ListNode o4 = new ListNode(4, null);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(1, o3);
        //------------------------------------------
        ListNode oa = new ListNode(6, null);
        ListNode ob = new ListNode(2, oa);
//        //------------------------------------------
//        ListNode oq = new ListNode(8, null);
//        ListNode ow = new ListNode(4, oq);
//        //------------------------------------------
//        ListNode oz = new ListNode(7, null);
//        ListNode ox = new ListNode(3, oz);

        ListNode[] lists = {o5, o2, ob/*, ow, ox*/};
        System.out.println(mergeKLists(lists));
    }

    /**
     * 给定两个升序链表， 按照升序合并两个链表
     * @param p1 -- 链表1
     * @param p2 --链表2
     * @return --新链表
     */
    public static ListNode mergeListAll(ListNode p1, ListNode p2){
        ListNode sentinel = new ListNode(666, null);  //定义哨兵节点
        ListNode p = sentinel;  //让新链表节点，指向哨兵节点

        while (p1 != null && p2 != null){  //当某一个链表指针指向null时，退出循环
            if (p1.val < p2.val){      //  谁的值小，谁就放到新节点上，然后向后移动
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;            //同上，
                p2 = p2.next;
            }
            p = p.next;                 //当新链表加入新的节点时，让指针后移，方便继续添加
        }
        if (p1 != null){                //当某一个链表为空的时候，把另一个链表后面整体赋值给新链表
            p.next = p1;
        }
        if (p2 != null){
            p.next = p2;
        }
        return sentinel.next;
    }

    /**
     * 合并多个链表
     * @param lists --
     * @return --
     */
    public static ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        return split(lists, 0, lists.length - 1);  // i = 0; j = length -1
    }

    /**
     * 合并多个已排序链表，合并完成依旧是已排序的：递归实现<br/>
     * 这里递归的思想： <br/>
     * 和二分查找不同，二分查找确定了重点mid，然后通过mid就是中间点的下标<br/>
     * 这里不同的是，算出了mid，只是用于分割i 和 j，  i传进来的是0， j传进来的是lists.length - 1<br/>
     * 第一次递归：通过重复计算mid，从而让j不断减小， 最终达到 i == j == 0。 就意味着，数组中的元素只有一个了。<br/>
     * 这时，返回lists[i]，也就是lists[0]。 表示左半部分分裂的最后一个数组（最左边数组）<br/>
     * 然后继续往下执行代码，确定了split(lists, mid + 1 = 1, j = 1);  ---> i == j。 这里就能确定了分裂的最下层数组的right数组<br/>
     * 最后，合并两个数组。<br/>
     * 然后，第二次<br/>
     * @param lists --
     * @param i  --左边界
     * @param j  --右边界
     * @return   --
     */
    //伪代码实现：
    //public static ListNode split(ListNode[3] lists, int i = 0, int j = 2){  //{L1,L2,L3}
    //    int mid = (i+j) >>> 1; //mid = (0+2)/2 = 1
    //    ListNode left = 							//split(lists, 0, mid=1)
    //        public static ListNode split(ListNode[] lists, int i = 0, int j = 1){
    //            int mid = (i+j) >>> 1; //mid = (0+1)/2 = 0
    //            ListNode left = 					//split(lists, 0, mid=0)
    //                public static ListNode split(ListNode[] lists, int 0, int 0){
    //                    if (i == j){  //数组内只有一个链表
    //                        return lists[i];   		//返回lists[0] = L1
    //                    }
    //                }
    //            ListNode right = 					//split(lists, mid + 1=1, j=1);
    //                public static ListNode split(ListNode[] lists, 1, int 1){
    //                    if (i == j){  //数组内只有一个链表
    //                        return lists[1];		//返回lists[1] = L2
    //                    }
    //                }
    //            return mergeListAll(left, right);   //此时 left = L1   right = L2 合并
    //        }   //这块代码就完成了， 返回给上层的left = {L1L2}（合并后）
    //    ListNode right = 							//split(lists, mid + 1 = 2, 2);
    //        public static ListNode split(ListNode[] lists, 2, 2){
    //            if (i == j){  //数组内只有一个链表
    //                return lists[i];   				//返回lists[2] = L3
    //            }
    //        }				//这里right 就等于 = L3
    //    return mergeListAll(left, right);   //合并{L1L2},{L3}
    //}
    public static ListNode split(ListNode[] lists, int i, int j){
        if (i == j){  //数组内只有一个链表
            return lists[i];
        }
        int mid = (i+j) >>> 1;
        ListNode left = split(lists, i, mid);
        ListNode right = split(lists, mid + 1, j);
        return mergeListAll(left, right);
    }
}
