package com.learning.queue;

import org.junit.jupiter.api.Test;

public class TestArrayQueue {

    @Test
    public void test01(){
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        for (Integer val : queue) {
            System.out.print(val);
        }
    }
}

