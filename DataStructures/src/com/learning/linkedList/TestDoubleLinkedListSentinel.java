package com.learning.linkedList;

import org.junit.jupiter.api.Test;

public class TestDoubleLinkedListSentinel {

    @Test
    public void test01(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addFirst(1);
        listSentinel.addFirst(2);
        listSentinel.addFirst(3);
        listSentinel.addFirst(4);

        for (Integer val : listSentinel) {
            System.out.println(val);
        }
    }
    @Test
    public void test02(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);

        for (Integer val : listSentinel) {
            System.out.println(val);
        }
    }

    @Test
    public void test03(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);

        listSentinel.insertByIndex(4, 11);

        for (Integer list : listSentinel) {
            System.out.println(list);
        }
    }

    @Test
    public void test04(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);

        listSentinel.removeFirst();

        for (Integer list : listSentinel) {
            System.out.println(list);
        }
    }
    @Test
    public void test05(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);

        listSentinel.removeLast();

        for (Integer list : listSentinel) {
            System.out.println(list);
        }
    }
    @Test
    public void test06(){
        DoubleLinkedListSentinel listSentinel = new DoubleLinkedListSentinel();
        listSentinel.addLast(1);
        listSentinel.addLast(2);
        listSentinel.addLast(3);
        listSentinel.addLast(4);

        listSentinel.removeByIndex(-1);

        for (Integer list : listSentinel) {
            System.out.println(list);
        }
    }
}
