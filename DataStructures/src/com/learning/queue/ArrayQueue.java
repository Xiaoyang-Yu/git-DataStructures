package com.learning.queue;

import java.util.Iterator;

public class ArrayQueue <E> implements Queue<E>, Iterable<E>{

    private E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()){
            return null;
        }
        E value = array[head];  //获取头节点的值
        head = (head + 1) % array.length; //头指针往前移，表示数组从head开始，就删除了之前的节点。
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;  //头尾指向同一个，说明queue为空
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;  // (tail + 1) % array.length 取模用于环形结构
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = array[p];
                p = (p + 1) % array.length;
                return val;
            }
        };
    }
}
