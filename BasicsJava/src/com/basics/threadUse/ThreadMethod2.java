package com.basics.threadUse;

public class ThreadMethod2 {
    public static void main(String[] args) throws InterruptedException {
        AA aa = new AA();
        aa.start();
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("main线程执行了" + i + "次");
            if (i == 5){
                System.out.println("=====AA线程先执行完成=====");
                aa.join();  //这里让aa线程先执行完成
                System.out.println("=====AA线程执行完毕，main线程继续执行=====");
            }
        }
    }
}
class AA extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AA线程执行了：" + i + "次");
        }
    }
}
