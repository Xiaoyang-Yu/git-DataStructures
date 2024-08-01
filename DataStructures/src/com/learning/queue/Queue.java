package com.learning.queue;

public interface Queue<E> {

    /**
     * 向队尾插入值
     * @param value  待插入值
     * @return -- 插入成功返回true，否则返回false
     */
    boolean offer(E value);

    /**
     * 从队头取值，并移除
     * @return 如果queue为空，返回 null，否则返回queue头的值
     */
    E poll();

    /**
     * 从队头取值，不移除
     * @return 如果queue为空，返回 null，否则返回queue头的值
     */
    E peek();

    /**
     * queue是否为空
     * @return 为空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 检查queue是否已满
     * @return 满返回true， 否则返回false
     */
    boolean isFull();
}
