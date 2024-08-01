package com.basics.threadUse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();  这里不能直接调用start()方法。
        // 这里实际是用了代理模式：静态代理进行调用的 start方法。
        Thread thread = new Thread(dog);
        thread.start();
    }
}
// 实现Runnable接口，是因为，如果Dog类已经继承了其他类，由于java的单继承，这里就不能再继承Thread类了。
class Dog implements Runnable {
    @Override
    public void run() {
        int count = 1;
        while (true){
            System.out.println("狗子嗷嗷叫" + count + "次" + "线程名称：" + Thread.currentThread().getName());
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 8){
                break;
            }
        }
    }
}
