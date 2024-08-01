package com.learning.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单项链表
 */
public class SingleLinkedList implements  Iterable<Integer>{

    private Node head; //头节点

    /**
     * 节点类
     * 这里做成内部类是因为：
     * 当Node做成内部类的时候，它作为底层代码，不需要向外暴漏。
     * 对外只需要SingleLinkedList一个类暴漏就够了
     * 使用private就更安全了
     * 为什么加static？  当这个内部类没有使用外部的成员变量的时候（比如 Node head）,就可以加static
     *                 当这个内部类使用了外部的成员变量的时候，就不能加 static
     */
    private static class Node{
        int value; //值
        Node next; //指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 按照索引删除
     * @param index --
     */
    public void removeByIndex(int index){
        if (index == 0){
            remove();
            return;
        }
        //找到索引位置 的前一个节点
        Node pre = findNode(index - 1);
        if (pre == null){
            throw new IllegalArgumentException("index：" + "[" + index + "]" + " 不合法");
        }
        //找到要删除的节点 的下一个节点
        Node remIndex = pre.next;
        if (remIndex == null){  //如果要删除的节点没找到，抛出异常
            throw new IllegalArgumentException("index：" + "[" + index + "]" + " 不合法");
        }
        // 让前一个直接的指针，指向，后一个节点（就是要删除的节点的指针指向的节点）
        pre.next = remIndex.next;
    }

    /**
     * 删除第一个元素
     */
    public void remove(){
        if (head == null){
            throw new IllegalArgumentException("空链表，不能删除");
        }
        //head指向的是第一个元素，所以head就可以看作是第一个元素
        //head.next，就是指向了第二个元素。
        head = head.next;
    }

    /**
     * 向给定索引节点插入
     * @param index --
     * @param value --
     */
    public void insertByIndex(int index, int value){
        if (index == 0){
            addFirst(value);
            return;
        }
        Node pre = findNode(index - 1);
        if (pre == null){
            throw new IllegalArgumentException("index:" + index + "不合法");
        }
        // new Node(value, pre.next) 新节点的指针，指向的就是pre指针原来指向的节点
        pre.next = new Node(value, pre.next);
    }

    /**
     * 头插法， 添加元素方法
     * @param val --
     */
    public void addFirst(int val){
        //1. 链表为空的情况 ---> 新加的节点的指针是为空的，因为链表里面没有其他元素
        //head = new Node(val, null);  //头节点指向新加的节点
        //2. 链表非空的情况
        //新加的元素指针指向刚才加的元素，也就是head指向的元素。
        //然后把头节点，指向新加的元素
        //这行代码的功能完全可以替代上面链表为空的情况，所以上面的代码可以删除掉（注释掉）。
        // 因为当第一次添加元素的时候，头节点就是null的，所以是一样的
        head = new Node(val, head);
    }

    /**
     * 尾插法：数据添加到末尾
     * 需要先找到链表的最后的元素，然后最后的元素指针指向新添加的元素
     * 新添加的元素指针是null
     * @param val --新加的值
     */
    public void addTail(int val){
        Node last = getTail();
        if (last == null){
            addFirst(val);  //如果是空链表，直接调用addFirst()方法添加就行
            return;
        }
        last.next = new Node(val, null);  //尾节点指向新添加的元素，

    }

    /**
     * 获取尾节点
     * @return 返回尾节点
     */
    private Node getTail(){
        if (head == null){   //如果链表是空的，直接返回null
            return null;
        }
        Node p;
        //通过循环找到尾节点
        for (p = head; p.next != null; p = p.next) {

        }
        return p;  //返回尾节点
    }

    /**
     * 根据索引查询
     * @return --返回索引对应的数据
     */
    public int get(int index){
        Node node = findNode(index);
        if (node == null){
            throw new IllegalArgumentException("index:" + index + "不合法");
        }
        return node.value;
    }

    /**
     * 根据索引查找节点
     * @return --返回节点
     */
    private Node findNode(int index){
        //定义链表索引
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++){  //遍历链表，索引随着遍历增加
            if (i == index){
               return p;  //返回节点 p
            }
        }
        return null; //没找到返回
    }

    /**
     * 实现Iterable<Integer>接口，重写iterator()方法
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new IntegerIterator();
    }

    /**
     * 这里把匿名内部类抽取了出来，
     * 这个类没有加 static关键字，
     * 因为它里面使用了外部类的成员变量 Node pointer = head   所以不能加static关键字
     */
    private class IntegerIterator implements Iterator<Integer> {
        Node pointer = head;  //指针，指向第一个元素（head指向的就是第一个元素）

        @Override
        public boolean hasNext() {  //检查是否有下一个元素，没有的时候返回false
            return pointer != null;
        }

        @Override
        public Integer next() {   //返回当前值，并指向下一个元素
            int value = pointer.value;
            pointer = pointer.next;
            return value;
        }
    }

    /**
     * 遍历链表 ：
     * Consumer<Integer> 这个东西，把决定交给用这个方法的地方
     * 在用这个方法的时候：
     * list.loop(value -{
     *     value.sout
     * })
     */
    public void loop(Consumer<Integer> consumer){
        Node p = head; //指针pointer指向第一个元素
        while (p != null){
            consumer.accept(p.value);
            p = p.next;  //指针指向下一个元素
        }
    }
}
