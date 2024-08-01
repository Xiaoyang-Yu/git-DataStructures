package com.basics.threadUse;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        new Thread(t).start();
        Thread.sleep(5*1000); //主线程main休眠10秒
        t.setLoop(false);
    }
}
class T implements Runnable {
    int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行：" + (++count));
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
