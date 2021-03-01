package com.example.javacode.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @data on 3/1/21 3:24 PM
 * @auther armStrong
 * @describe 创建线程的三种方法，基本使用
 */
public class ThreadBaseUse {
    public static void main(String[] args) {
        /**
         *   方法1：继承Thread类，重新run()方法
         */
        new Thread1().start();
        /**
         *   方法2：实现java.lang.Runnable接口，重写run()方法，然后使用Thread类来包装
         */
        // 将Runnable实现类作为Thread的构造参数传递到Thread类中，然后启动Thread类
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
        /**
         *   方法3：实现Callable接口，重写call()方法，然后包装成java.util.concurrent.FutureTask, 再然后包装成Thread
         */
        //将Callable包装成FutureTask，FutureTask也是一种Runnable
        MyCallable callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        /**
         *  【三种方式比较】==>>
         *   Thread: 继承方式, 不建议使用, 因为Java是单继承的，继承了Thread就没办法继承其它类了，不够灵活。
         *   Runnable: 实现接口，比Thread类更加灵活，没有单继承的限制。
         *   Callable: Thread和Runnable都是重写的run()方法并且没有返回值，Callable是重写的call()方法并且有返回值并可以借助FutureTask类来判断线程是否已经执行完毕或者取消线程执行。
         *   当线程不需要返回值时使用Runnable，需要返回值时就使用Callable，一般情况下不直接把线程体代码放到Thread类中，一般通过Thread类来启动线程。
         *   Thread类是实现Runnable，Callable封装成FutureTask，FutureTask实现RunnableFuture，RunnableFuture继承Runnable，所以Callable也算是一种Runnable，所以三种实现方式本质上都是Runnable实现。
         */
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("CreateThreadFunction1==>>");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("CreateThreadFunction2==>>");
    }
}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("CreateThreadFunction3==>>");
        return null;
    }
}
