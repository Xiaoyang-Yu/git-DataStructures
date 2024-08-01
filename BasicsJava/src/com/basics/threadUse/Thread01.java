package com.basics.threadUse;

public class Thread01 {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.start(); //开启线程，会调用run()方法。
    }
}
/**
 * 第一种方式：
 * 1. Cat类继承Thread的类，就表示该类是一个线程
 * 2. 重写run()方法，在里面写上自己的业务逻辑代码
 * 这个run方法其实是 Thread类实现了Runnable接口，重写的run()方法。
 */
class Cat extends Thread{

    int times = 1;
    @Override
    public void run() {

        while (true){
            System.out.println("输出了：" + times + "次");
            times++;
            try {
                Thread.sleep(1000);  //间隔1秒， 这里的单位是毫秒，所以是1000，需要抛出异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times > 8){
                break;
            }
        }


    }
}
