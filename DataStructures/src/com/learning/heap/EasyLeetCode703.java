package com.learning.heap;

import java.util.PriorityQueue;

public class EasyLeetCode703 {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public EasyLeetCode703(int k, int[] nums) {
        this.k = k;
        //给定了堆的大小，就是k。  k表示第几大的元素，比如第3大的元素，那么就设定堆的大小就是3
        //这样方便用于返回，因为优先级队列就是最小堆， 所以返回堆顶元素，就是第k大的元素
        this.minHeap = new PriorityQueue<>(k);
        for (int num : nums) {  //模拟流，不断加入元素
            add(num);
        }
    }
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (val > minHeap.peek()){  // 如果新加的值比堆顶元素大
            minHeap.poll(); // 那么，就移除堆顶元素，并且
            minHeap.add(val);  //把新值加入到最小堆中。
        }
        return minHeap.peek();
    }
}
