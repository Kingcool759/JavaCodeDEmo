package com.example.javacode.singleton;

import java.util.Date;


/**
 * @data on 3/1/21 12:06 PM
 * @auther armStrong
 * @describe 单例模式-饿汉式
 */

//饿汉模式：线程安全，耗费资源。
public class HugerSingleton {

    //(1)属性实例化对象，该对象的引用不可修改
//    private static final HugerSingleton outInstance = new HugerSingleton();

    //(2)在静态代码块中实例化对象，可进行对象属性的相关操作，比如，网络请求那块，就是使用了静态代码块完成的。
    private static HugerSingleton outInstance;

    /**
     * 静态代码块和静态变量只在类编译时期类加载（classLoader）的时候执行，在此例中，也就是执行new HugerSingleton()操作
     * 如果类已经被加载：静态代码块和静态变量不在重复执行，再创建类对象时，只执行与实例相关的变量初始化和构造方法。
     * 因此，多线程中，饿汉式，是线程安全的。
     */
    static {
        outInstance = new HugerSingleton();
    }

    public static HugerSingleton getInstance() {
        return outInstance;
    }

    HugerSingleton() {
        System.out.println("[==>>HugerSingleton==>>]:  " + new Date());
    }
}
