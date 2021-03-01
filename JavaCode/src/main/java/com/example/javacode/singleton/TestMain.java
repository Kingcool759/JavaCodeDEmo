package com.example.javacode.singleton;

import java.util.concurrent.TransferQueue;

/**
 * @data on 3/1/21 1:46 PM
 * @auther armStrong
 * @describe 调用单例模式实体类
 */
public class TestMain {
    public static void main(String[] args) {
//        /**
//         * 单线程下
//         */
//        //饿汉式：当创建对象则立即进行实例化操作
//        HugerSingleton hugerSingleton = HugerSingleton.getInstance();  //==>>HugerSingleton
//        //懒汉式：
//        Singleton singleton = Singleton.getInstance();  //==>>Singleton

        /**
         * 多线程下
         */
        new T1().start();
        new T2().start();
        new T3().start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        super.run();
        //饿汉式
        HugerSingleton hugerSingleton = HugerSingleton.getInstance();  //==>>HugerSingleton
        //懒汉式
        Singleton singleton = Singleton.getInstance();  //==>>Singleton

    }
}

class T2 extends Thread {
    @Override
    public void run() {
        super.run();
        HugerSingleton hugerSingleton = HugerSingleton.getInstance();  //==>>HugerSingleton

        Singleton singleton = Singleton.getInstance();  //==>>Singleton
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        super.run();
        HugerSingleton hugerSingleton = HugerSingleton.getInstance();  //==>>HugerSingleton

        Singleton singleton = Singleton.getInstance();  //==>>Singleton
    }
}
