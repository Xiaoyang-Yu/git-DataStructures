package com.learning.heap;

/**
 * 大顶堆：
 * 每个父亲节点都比孩子节点大
 */
public class MaxHeap {
    int[] array;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    //获取堆顶元素
    public int peek(){
        return array[0];
    }

    /**
     * 删除堆顶元素:
     * 直接删除堆顶元素array[0]效率不高，所以，<br/>
     * 1. 把堆顶元素和 最后元素交换，然后删除<br/>
     * 2. 把交换后的堆顶元素下潜。
     * @return
     */
    public int poll(){
        int top = array[0];
        swap(0, size - 1);
        size--;   //相当于删除最后一个元素
        down(0);  //下潜索引0的元素
        return top;
    }

    /**
     * 删除指定位置的元素： <br/>
     * 原理和上面一样，先交换到末尾，然后删除，再下潜
     * @param index 索引
     * @return 返回删除的元素
     */
    public int poll(int index){
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     * @param replaced -
     */
    public void replace(int replaced){
        array[0] = replaced;
        down(0);
    }

    /**
     * 向堆的尾部添加元素
     * @param offered 待添加元素
     * @return 添加成功返回true
     */
    public boolean offer(int offered){
        if (size == array.length){
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    //上浮操作，将元素上浮，直到该元素offered小于父元素或到堆顶
    private void up(int offered){
        int child = size;   // 默认新加的元素的位置 == size
        while (child > 0){
            int parent = (child - 1) / 2;  //新元素的父亲节点
            if (offered > array[parent]){
                array[child] = array[parent];   //把parent元素下移
            }else {
                break;
            }
            child = parent;   //更新child下标
        }
        array[child] = offered;  //赋值
    }

    //建堆
    private void heapify(){
        //如何找到最后这个非叶子节点： size/2 - 1
        for (int i = size / 2 - 1; i >= 0 ; i--) {
            down(i);
        }
    }

    //下潜方法，将parent索引处的元素下潜：与两个孩子较大者交换，直至没孩子或者孩子没它大
    private void down(int parent){
        int left = parent * 2 + 1; // 左孩子的索引
        int right = left + 1; // 右孩子索引  也可以写成： parent*2+2
        int max = parent; //max表示 parent下两个孩子，大的孩子的值， 先假设parent的值就是最大的
        if (left < size && array[left] > array[max]){  //如果左孩子处的值要大于 max，那么就更新左孩子是max
            max = left;
        }
        if (right < size && array[right] > array[max]){
            max = right;
        }
        if (max != parent){   //如果这个max不等于了parent，表示找到了更大的孩子
            //交换
            swap(max,parent);  //把max处的值和 parent处的值交换
            down(max);   //最后进行递归，一直下潜到结束
        }
    }
    //交换两处索引的值
    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
