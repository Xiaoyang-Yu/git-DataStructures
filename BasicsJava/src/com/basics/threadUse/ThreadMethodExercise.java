package com.basics.threadUse;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        BB bb = new BB();
        Thread thread = new Thread(bb);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi "+ i + "次");
            if (i == 5){
                System.out.println("=====BB线程开始执行======");
                thread.start();
                thread.join();
                System.out.println("=====BB线程执行完成======");
                System.out.println("=====main线程继续执行======");
            }
        }
        System.out.println("=====main线程执行完成======");
    }
}
//1. 主线程每隔1秒，输出一次 hi  一共10次
//2. 当输出到 第五次 hi 的时候，启动一个子线程（实现Runnable接口）,
//   每隔1秒输出hello，等该线程输出10次hello后，退出
//3. 主线继续输出hi ，直到退出
class BB implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + i + "次");
        }
    }
}
