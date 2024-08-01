package com.basics.threadUse;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        R r = new R();
        Thread thread = new Thread(r);
        //如果是用继承的方式，则直接r.setName()就行
        thread.setName("设置线程的名字为：");
        thread.setPriority(Thread.MIN_PRIORITY);  //设置线程优先级：优先级由三个，最小=1、默认=5、最大=10
        thread.start();
        //主线程打印5个“hi”， 就中断子线程的休眠(直接执行catch里面的内容，然后继续循环的代码)
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }
        thread.interrupt();
    }
}
class R implements Runnable {
    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子~~~" + i);
            }
            try {
                Thread.sleep(20000); //20秒休眠
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException是捕获一个中断异常
                System.out.println(Thread.currentThread().getName() + "被中断了~~~");
            }
        }
    }
}
