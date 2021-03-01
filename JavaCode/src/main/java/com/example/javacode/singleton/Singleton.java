package com.example.javacode.singleton;

import java.util.Date;

/**
 * @data on 3/1/21 1:42 PM
 * @auther  armStrong
 * @describe  单例模式-懒汉式
 */

//非线程安全
public class Singleton {
    private static Singleton outInstance;

    public static Singleton getInstance(){
        if (null == outInstance){
            outInstance = new Singleton();
        }
        return outInstance;
    }

    private Singleton(){
        System.out.println("[==>>Singleton==>>]:  "+ new Date());
    }

    public void function(){
        System.out.println("懒汉式"+ new Date());
    }
}
