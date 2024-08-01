package com.learning.queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private Node<E> head = new Node<>(null, null);  //哨兵
    private Node<E> tail = head;        //尾节点 -> 头节点
    private int size;           //节点个数
    private int capacity = Integer.MAX_VALUE;       //容量

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        tail.next = head;
    }

    //环形链表
    public LinkedListQueue() {
        tail.next = head;
    }


    //节点类
    private static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        //head是不动的，一直指向哨兵节点
        Node<E> newNode = new Node<>(value, head);
        tail.next = newNode;   //tail指向新节点
        tail = newNode;         //更新tail为新节点
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()){
            return null;
        }
        Node<E> first = head.next;  //拿到第一个节点
        head.next = first.next;    // 删除第一个节点
        if (first == tail){  //只有一个节点的时候， 节点移除之后，尾指针得指向head
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return head.next.value; //哨兵的下一个节点的值
    }

    @Override
    public boolean isEmpty() {
        return head == tail;   //头尾相等就为空
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
