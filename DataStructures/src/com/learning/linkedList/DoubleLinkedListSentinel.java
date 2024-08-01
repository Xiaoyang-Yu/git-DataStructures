package com.learning.linkedList;

import java.util.Iterator;

/**
 * 双向链表（带哨兵Sentinel）
 */
public class DoubleLinkedListSentinel implements Iterable<Integer>{

    /**
     * 属性和构造方法：
     * 指定，head哨兵、tail哨兵
     * 初始化： head哨兵指向tail哨兵、 tail哨兵指向head哨兵
     */
    private Node head; //头节点
    private Node tail; //尾节点
    public DoubleLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null,888, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 节点类
     */
    private static class Node {
        private Node prev;  //前指针
        private int value;  //值
        private Node next;  //后指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 工具方法，根据索引查找节点
     * @param index --索引
     * @return 返回节点
     */
    private Node findNode(int index){
        int i = -1;  //定义索引，从-1开始，-1表示是头节点哨兵
        //  从head（头哨兵）开始遍历； 当p（节点）等于tail（尾哨兵）的时候退出循环；
        for(Node p = head; p != tail; p = p.next, i++){
            if (i == index){
                return p;
            }
        }
        return null; //没有找到，返回null
    }

    /**
     * 根据索引插入
     * @param index --索引
     * @param value --插入值
     */
    public void insertByIndex(int index, int value){
        Node preNode = findNode(index - 1);  //待插入节点的前一个节点
        if (preNode == null){
            throw illegalIndexException(index);
        }
        Node nextNode = preNode.next;              //待插入节点的后一个节点
        Node insertedNode = new Node(preNode, value, nextNode);
        preNode.next = insertedNode;    //前一个节点的 next指针指向新节点
        nextNode.prev = insertedNode;   //后一个节点的 prev指针指向新节点
    }

    /**
     * 头插法
     */
    public void addFirst(int value){
        insertByIndex(0,value);
    }

    /**
     * 尾插法
     * @param value -- 插入值
     */
    public void addLast(int value){
        Node lastNode = tail.prev; //根据tail拿到最后一个节点
        Node insertNode = new Node(lastNode, value, tail);
        lastNode.next = insertNode;
        tail.prev = insertNode;
    }

    /**
     * 根据索引删除
     * @param index --索引
     */
    public void removeByIndex(int index){
        //1. 找到待删除节点、 前一个节点、后一个节点
        Node remNode = findNode(index);
        if (remNode == null || remNode == tail){
            throw illegalIndexException(index);
        }
        Node prevNode = remNode.prev;
        if (prevNode == null){
            throw illegalIndexException(index);
        }
        Node nextNode = remNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * 删除第一个元素
     */
    public void removeFirst(){
        removeByIndex(0);
    }

    /**
     * 删除最后一个元素
     */
    public void removeLast(){
        Node lastNode = tail.prev;  //获取最后一个节点
        if (lastNode == head){
            throw illegalIndexException(0);
        }
        Node prev = lastNode.prev;  //获取最后一个节点的前一个节点

        prev.next = tail;   //前一个节点的next指针 指向tail
        tail.prev = prev;   //tail的prev指针  指向前一个节点
    }

    /**
     * 迭代器
     * @return --
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;   // head.next 表示从头哨兵之后的 第一个元素开始，如果没有.next就是从头哨兵开始了
            @Override
            public boolean hasNext() {
                return p != tail;
            }
            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;  //别忘了移动指针
                return value;
            }
        };
    }

    /**
     * 抽取异常方法
     * @param index --
     * @return --
     */
    private IllegalArgumentException illegalIndexException(int index) {
        return new IllegalArgumentException("index:" + "[" + index + "] 不合法");
    }

}
