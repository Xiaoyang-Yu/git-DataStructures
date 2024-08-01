package com.learning.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        CircleQueue arrayQueue = new CircleQueue(3);
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

//循环队列，为了解决之前的问题
//在这个代码中，加入了一些算法，主要是取模
//front 和 rear 的初始值从-1 变成了 0 .
//意味着，front就是直接指向第一个元素，也就是arr[front]；rear指向了队列的最后一个元素的后一个位置。
class CircleQueue {
    private int maxSize; //队列最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  //该数组用于存放数据

    //创建构造器
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满 判断条件变为，(rear + 1)%maxSize == front
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = val;
        //将rear后移，这里必须考虑取模。如果不这样，当数组添加满的时候，rear指向最后一个元素的后一个位置，会导致数组index越界
        rear = (rear + 1) % maxSize;
    }

    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可以取出");
        }
        //这里需要分析出，front是指向队列的第一个元素
        //1. 先把front对应的值保存到临时变量
        //2. front后移,同样需要取模操作
        //3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("空队列，没有数据可以显示");
        }
        //思路：从front开始遍历
        // 条件则变为，i小于front + 有效数据个数
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + i % maxSize +"]:" + arr[i % maxSize]);
        }
    }

    //显示队列头部数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("空队列，没有Head数据可以显示");
        }
        return arr[front];
    }

    //求出当前队列有效数据个数
    public int size(){
        //rear = 1 , front = 0 , maxSize = 3  有效1个
        //rear = 0 , front = 0 , maxSize = 3  有效0个
        //rear = 2 , front = 1 , maxSize = 3  有效1个
        //rear = 2 , front = 0 , maxSize = 3  有效2个
        return (rear + maxSize - front) % maxSize;
    }

}

/*
在循环队列中，取模操作的作用是确保队列的尾指针 rear 和头指针 front 在数组中循环移动时能够正确地指向数组的有效位置，以避免越界访问或者错位的问题。让我们来详细解释一下：

添加元素时的取模操作：
在添加元素时，队列的尾指针 rear 指向下一个可用位置。取模操作 (rear + 1) % maxSize 保证了 rear 始终在 [0, maxSize-1] 的范围内循环移动，
当 rear 移动到数组的末尾时，取模操作将其置为 0，使其继续指向数组的头部，从而形成循环。

取出元素时的取模操作：
在取出元素时，队列的头指针 front 同样需要进行取模操作，以保证它在数组中正确地移动。
当取出元素后，front 移动到下一个位置，取模操作 (front + 1) % maxSize 确保了 front 的循环移动，当 front 移动到数组的末尾时，取模操作将其置为 0，使其继续指向数组的头部。

计算队列有效数据个数时的取模操作：
在计算队列中有效数据个数时，由于循环队列可能出现头指针 front 在尾指针 rear 之后的情况（例如，rear < front），因此需要确保计算出的有效数据个数始终为正数。
取模操作 (rear + maxSize - front) % maxSize 确保了即使 rear < front 时，计算结果也为正数，从而正确地计算出队列中有效数据的个数。

这种取模操作的思想是基于循环队列的特性，通过保证指针在数组中正确循环移动，确保了循环队列的正常操作，并且在计算有效数据个数时处理了特殊情况，使得代码更加健壮和通用。
 */
