package com.learning.linkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class TestSingleLinkedList {

    @Test
    public void test(){
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop(value->{
            System.out.println(value);
        });

    }
    @Test
    public void test2(){
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        int i = list.get(5);
        System.out.println(i);
    }
    @Test
    public void test4(){
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1); //0
        list.addTail(2); //1
        list.addTail(3); //2
        list.addTail(4); //3
        list.insertByIndex(0, 11);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    @Test
    public void test5(){
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1); //0
        list.addTail(2); //1
        list.addTail(3); //2
        list.addTail(4); //3
        list.remove();

        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------");
        list.remove();

        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------");
        list.remove();

        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------");
        list.remove();

        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------");
        list.remove();

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    @Test
    public void test6(){
        SingleLinkedList list = new SingleLinkedList();
        list.addTail(1); //0
        list.addTail(2); //1
        list.addTail(3); //2
        list.addTail(4); //3
        //list.removeByIndex(0);
        list.removeByIndex(4);  //找到上一个节点，但是没有找到要删除的节点

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
