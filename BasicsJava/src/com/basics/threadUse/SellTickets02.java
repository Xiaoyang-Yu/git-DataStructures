package com.basics.threadUse;

public class SellTickets02 {
    public static void main(String[] args) {
        TicketsSyn ticketsSyn = new TicketsSyn();
        Thread thread1 = new Thread(ticketsSyn);
        Thread thread2 = new Thread(ticketsSyn);
        Thread thread3 = new Thread(ticketsSyn);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketsSyn implements Runnable {
    private static int tickets = 100;  //剩余票数量
    private static boolean loop = true;
    //实现同步
    public synchronized void sell(){
        if (tickets <= 0){
            System.out.println("没有票了");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tickets--;
        System.out.println("窗口：" + Thread.currentThread().getName() + "卖出了一张票，还剩：" + tickets + "张。");
    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
