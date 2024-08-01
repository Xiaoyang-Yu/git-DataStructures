package com.learning.recursion;

/**
 * 递归实现插入排序算法：
 *  例如{1,41,25,37,11,22,44}
 *  假设，下标0为已排序区域， 剩下的都是未排序区域
 *  按照升序把每个数字插入到对应的位置。
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2,4,5,10,7,1};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort(int[] arr){
        insertion(arr, 1); //默认除了下标为0的区域外， 都是未排序区域
    }

    /**
     * 递归方法，实现插入
     * @param arr --数组
     * @param low --未排序区域的左边界
     */
    public static void insertion(int[] arr, int low){
        //如果未排序区域的左边界low（按照假设，low==1） 已经等于 数组的长度，那么说明已经排序完成，则退出递归
        if (low == arr.length){
            return;
        }
        //临时变量temp的值等于 low位置的值，让temp和已排序区域的右边界i 进行比较
        int temp = arr[low];
        // 已排序区域的右边界 i ,  low - 1就是已排序区域
        int i = low - 1;
        // 如果arr[i] > temp 的时候，进入循环，把arr[i]往后移一位
        // 不能让i小于0， 小于0超出了数组下标
        while (i >= 0 && arr[i] > temp){
            arr[i + 1] = arr[i];  //往后移一位
            i--;   //继续往前进行比较
        }
        //退出循环表示找到插入位置
        // 这个判断排除了多余的赋值操作
        if (i+1 != low) {
            //为什么是i+1： arr[i]经过上面的循环，它就是比temp大的最右边界，所以 +1 的位置就是插入位置
            arr[i + 1] = temp;
        }
        insertion(arr, low + 1);
    }

}
