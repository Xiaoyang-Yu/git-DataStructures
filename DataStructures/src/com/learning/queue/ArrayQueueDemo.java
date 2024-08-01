package com.learning.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        ArrayQueue11 arrayQueue = new ArrayQueue11(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 增加");
            System.out.println("g(get): 取出");
            System.out.println("h(head): 头部");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = arrayQueue.showHead();
                        System.out.println("队列头数据是：" + headData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出--------------");

    }
}
/* 这段代码存在很大问题，当存满时，再全部取出，依然显示队列已满，不能存入。而且当取出数据之后，在显示队列，还是会出现原来的数据。*/
//使用数组模拟队列- 创建一个ArrayQueue类， 其中需要用到的变量有：1.队列头；2.队列尾部；3.队列最大容量；4.用于实现队列的数组。
//队列的特点是，先进先出。  意思是，哪个数据先进去，哪个数据先出来。
class ArrayQueue11 {

    private int maxSize; //队列最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  //该数组用于存放数据

    //创建构造器
    public ArrayQueue11(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部， -1代表指向队列头部前一个位置
        rear = -1;  //指向队列尾部，指向队列尾的数据（就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列满，不能添加");
            return;
        }
        rear++;
        arr[rear] = val;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可以取出");
        }
        front++;
        return arr[front];
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("空队列，没有数据可以显示");
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i +"]:" + arr[i]);
        }
    }

    //显示队列头部数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("空队列，没有Head数据可以显示");
        }
        return arr[front + 1];
    }

}
