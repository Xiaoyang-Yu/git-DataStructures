package com.learning.queue;

import org.junit.jupiter.api.Test;

public class TestLinkedListQueue {

    @Test
    public void testQueue(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
    }

    @Test
    public void testQueue2(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
        System.out.println();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println("-------------");
        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
    }
}
