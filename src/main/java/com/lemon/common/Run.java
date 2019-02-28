package com.lemon.common;

/**
 * @Author: yinft
 * @Date: 2019/2/27 21:33
 * @Version 1.0
 */
public class Run {

    public static void main(String[] args) {
        MyThread mythread=new MyThread();
        //下列线程都是通过mythread对象创建的
        Thread a=new Thread(mythread,"A");
        Thread b=new Thread(mythread,"B");
        Thread c=new Thread(mythread,"C");
        Thread d=new Thread(mythread,"D");
        Thread e=new Thread(mythread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}

class MyThread extends Thread {
    private int count = 5;

    @Override
    public  void  run() {
        super.run();
        count--;
        System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}