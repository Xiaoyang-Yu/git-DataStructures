package com.learning.binarySearch;

public class BinarySearchBasic {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int index = BinarySearchBasic(arr, 10);
        System.out.println(index);
    }

    /**
     * 最左，最右，以及修改版的应用
     * 几个名词：
     *  target： 目标值
     *  排名：    target所在的最左位置 + 1  就是排名
     *  前任：    target所在的最左位置 的前一个位置
     *  后任：    target所在的最右位置 的后一个位置
     *  最近邻居： {1，4，4，4，7，8}  5的最近邻居就是4， 因为5-4=1--> 距离最近 ， 7-5=2 , 距离大
     */
    public static void application(){
        int[] arr = {1,4,4,4,7,8};
        int index = 0;
        int ranked = 0;
        //求排名 --> 目标值存在数组中
        index = BinarySearchLeftMost2(arr, 4);
        ranked = index + 1;  //因为数组索引从0开始，所以排名要+1
        System.out.println(ranked);
        //求排名 --> 目标值不存在数组中
        int index_n = BinarySearchLeftMost2(arr, 5);  //返回的是插入位置，就是比目标值大的第一个元素的位置
        ranked = index_n + 1;
        System.out.println(ranked);

        //求前任 --> 目标值存在数组中
        index = BinarySearchLeftMost2(arr, 4);
        ranked = index - 1;  //目标值最左的前一个位置
        System.out.println(ranked);
        //求前任 --> 目标值存在数组中
        index = BinarySearchLeftMost2(arr, 5);  //找不到5，所以目标值的位置应该是数据7的位置，也就是返回4
        ranked = index - 1;  // 下标4的前一个位置，就是前任
        System.out.println(ranked);

        //求后任 --> 目标值存在数组中
        index = BinarySearchRightMost2(arr, 4);
        ranked = index + 1;  //目标值最右的后一个位置
        System.out.println(ranked);
        //求后任 --> 目标值存在数组中
        index = BinarySearchRightMost2(arr, 5);;  //找不到5，所以目标值的位置应该是小于等于5的最右的位置，也就是最右边的4的下标3
        ranked = index + 1;  // 下标3的后一个位置，就是后任
        System.out.println(ranked);

        //范围查找：
        //1. 找到所有target <4  的值: 0 <= target < leftMost(4) - 1  (不包含4)
        //2. 找到所有target <=4 的值: 0 <= target <= rightMost(4)    (包含4)
        //3. 找到所有target >4  的值: rightMost(4) < target <= 无穷大 (不包含4)
        //4. 找到所有target >=4 的值： leftMost(4) <= target <= 无穷大 (包含4)
        //5. 找到所有4 <= target <= 7 的值: leftMost(4) <= target <= rightMost(7)
        //6. 找到所有4 < target < 7 的值:   rightMost(4) + 1 <= target <= leftMost(7) - 1

    }

    /**
     * 二分查找基础版：
     * @param arr -- 有序数组
     * @param target --查找的目标值
     * @return 找到目标所在位置，返回索引，-1表示没找到
     */
    public static int BinarySearchBasic(int[] arr, int target){
        // 检查数组是否为空
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //起始位置和末尾位置
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            /**
             * 中间索引： 这里为什么不用(start + end) / 2
             * >>> 表示无符号右移1位，基于2进制 。
             * 如果end的值是int的最大值，那么用(start + end) / 2的话，当start > 1的时候，两数相加超过了int的最大取值范围
             * 就出现了负数，结果不准确
             * 用>>> 就解决了这个问题
             */
            int mid = (start + end) >>> 1;    //(start + end) / 2
            //1. 如果target = mid，返回mid
            if (target < arr[mid]) {
                end = mid - 1;              //target 在左半部分
            }else if (arr[mid] < target) {  //target > arr[mid]
                start = mid + 1;            // target 在右半部分
            }else{                          // target == arr[mid] 表示找到位置
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找：当数组中存在多个重复值，比如 {11，21，33，33，33，45，45，57，96}
     *
     * @param arr   -- 有序数组
     * @param target    --查找的目标值
     * @return -- 返回目标值在数组中最左的位置
     */
    public static int BinarySearchLeftMost(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        int candidate = -1;  //设置候选者，每一次找到目标位置都视为是候选位置。直到找到最左的目标。 如果不存在，返回-1
        while (start <= end){
            int mid = (start + end) >>> 1;
            if (target < arr[mid]){
                end = mid - 1;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else {
                candidate = mid;   //找到目标值所在
                end = mid - 1;     //让右指针往前移，继续查找是否还有相同的元素。直到右指针小于左指针，退出循环。
            }
        }
        return candidate;
    }

    /**
     * 二分查找：当数组中存在多个重复值，比如 {11，21，33，33，33，45，45，57，96}
     *
     * @param arr   -- 有序数组
     * @param target    --查找的目标值
     * @return -- 返回目标值在数组中最右的位置
     */
    public static int BinarySearchRightMost(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        int candidate = -1;  //设置候选者，每一次找到目标位置都视为是候选位置。直到找到最左的目标。 如果不存在，返回-1
        while (start <= end){
            int mid = (start + end) >>> 1;
            if (target < arr[mid]){
                end = mid - 1;
            }else if (arr[mid] < target){
                start = mid + 1;
            }else {
                candidate = mid;   //找到目标值所在
                start = mid + 1;     //让左指针往后移，继续查找是否还有相同的元素。直到右指针小于左指针，退出循环。
            }
        }
        return candidate;
    }

    /**
     * 二分查找目标所在最左值：修改版   假设数组为{11，21，33，33，33，45，45，57，96}
     * 上面的代码中，如果找不到target，那么candidate = -1；  其实 -1 没有实际的意义，
     * 在这里，我们返回更有意义的值。
     *
     * 假设target = 33， 那么要返回最左边的33的索引 ---> 2
     * 如果target = 15，数组中不存在目标值，那么返回的是最靠左的索引（也可以看作是插入位置），就是21的索引 ---> 1
     * @param arr   -- 有序数组
     * @param target  --查找的目标值
     * @return 找到目标所在位置，返回索引
     */
    public static int BinarySearchLeftMost2(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            if (target <= arr[mid]){   // 按照上面的代码，当target < arr[mid] 或者target == target的时候，end都是 end = mid - 1
                end = mid - 1;         // 所以可以合并成一个， 表示end指针左移
            }else{
                start = mid + 1;
            }
        }
        //当while循环结束时，start将是目标值在数组中最左位置的索引。如果目标值不存在于数组中，start将是比目标值大的第一个元素的位置。
        return start;
    }

    /**
     * 二分查找目标所在最右值：修改版   假设数组为{11，21，33，33，33，45，45，57，96}
     * 上面的代码中，如果找不到target，那么candidate = -1；  其实 -1 没有实际的意义，
     * 在这里，我们返回更有意义的值。
     * @param arr   -- 有序数组
     * @param target    --查找的目标值
     * @return -- 找到目标所在位置，返回索引
     */
    public static int BinarySearchRightMost2(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            if (target < arr[mid]){
                end = mid - 1;
            }else {
                // 让start一直往后移，继续查找是否还有相同的元素。直到大于end的时候，退出循环。
                // 此时的start位于end的后一位，start - 1就是目标值的最右位置
                start = mid + 1;
            }
        }
        //当 while 循环结束时，start 将是比目标值大的第一个元素的位置。因此，返回 start - 1，它是目标值在数组中的最右位置。
        return start - 1;
    }

}
