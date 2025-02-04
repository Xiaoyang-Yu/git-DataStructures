package com.learning.stack;

public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * @param value 待压入值
     * @return  压入成功返回true， 失败返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，为空返回null
     */
    E pop();

    /**
     * 返回栈顶元素，不弹出
     * @return 栈非空返回栈顶元素，为空返回null
     */
    E peek();

    /**
     * 判断栈中是否为空
     * @return 为空返回true，不为空返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return 已满返回true，否则返回false
     */
    boolean isFull();
}
