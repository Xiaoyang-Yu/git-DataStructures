package com.learning.heap;

import java.util.PriorityQueue;

public class HardLeetCode295 {

    /*
     *  1 2 3     7 8 9
     *  s s 3     7 s s
     */

    private PriorityQueue<Integer> right = new PriorityQueue<>();   //小顶堆

    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );

    public HardLeetCode295(int[] nums) {
        for (int num : nums) {
            addNum(num);
        }
    }

    /**
     * 为了 保证两边数据量平衡： 左边是最大堆，右边是最小堆
     * 两边个数一样时，左边个数加 1
     * 不一样时，右边个数加 1
     * 但是，
     * 左边个数加 1时，新元素先加到右边，然后弹出右边最小的加入左边
     * 右边个数加 1时，新元素先加到左边，然后弹出左边最大的加入右边
     * @param num 新值
     */
    public void addNum(int num) {
        if (left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else {
            left.offer(num);
            right.offer(left.poll());
        }
    }
    /**
     * 两边数据数量一样的时候，中位数是两个堆顶 元素 相加 再除以2
     * 左边多，中位数就是 最小堆的 堆顶元素
     * @return
     */
    public double findMedian() {
        if (left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return left.peek();
        }
    }
}
