package com.basics.threadUse;

public class SellTickets {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread thread01 = new Thread(tickets);
        Thread thread02 = new Thread(tickets);
        Thread thread03 = new Thread(tickets);
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
class Tickets implements Runnable {
    private static int tickets = 100;  //剩余票数量
    @Override
    public void run() {
        while (true) {
            if (tickets <= 0){
                System.out.println("没有票了");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
            System.out.println("窗口：" + Thread.currentThread().getName() + "卖出了一张票，还剩：" + tickets + "张。");
        }
    }
}
