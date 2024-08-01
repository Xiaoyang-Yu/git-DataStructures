package com.learning.leetcode;

public class LinkedListEasyLeetCode88 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i);
        }
    }

    /**
     * 合并两个有序数组：<br/>
     * 给两个按 非递减顺序 排列的整数数组 nums1 和 nums2，<br>
     * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。<br>
     * 请 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。<br/>
     * 最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。<br/>
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。<br/>
     * 示例 1：<br>
     *    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3<br>
     *    输出：[1,2,2,3,5,6]<br>
     *    解释：需要合并 [1,2,3] 和 [2,5,6] 。<br>
     *    合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。<br>
     * @param nums1
     * @param m
     * @param nums2
     * @param n

     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;  // 第一个数组的指针
        int p2 = 0;  //第二个数组的指针
        int i = 0;  //新数组的下标
        int[] arr = new int[m+n];   //新数组的大小
        while (p1<m && p2 < n){
            if (nums1[p1] < nums2[p2]){
                arr[i] = nums1[p1];
                p1++;
            }else {
                arr[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        if (p1 >= m){  //处理剩余元素
            System.arraycopy(nums2,p2, arr, i, n - p2);
        }
        if (p2 >= n){
            System.arraycopy(nums1,p1, arr, i, m - p1);
        }
        System.arraycopy(arr,0, nums1, 0, arr.length);
    }
}
