package com.basics.threadUse;

public class ThreadDaemon_ {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true); //设置守护线程，当主线程结束时，守护线程自动结束
        //设置守护线程要放在start()前面
        thread.start();
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("main线程执行中~~~~~");
            Thread.sleep(1000);
        }
    }
}
class DaemonThread implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("子线程执行中-----");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
