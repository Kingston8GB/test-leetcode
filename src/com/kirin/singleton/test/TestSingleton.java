package com.kirin.singleton.test;

import com.kirin.singleton.SingletonEager;
import com.kirin.singleton.base.SingletonImpl;
import com.kirin.singleton.SingletonInnerClazz;
import com.kirin.singleton.SingletonLazy;
import com.kirin.singleton.SingletonDCL;
import com.kirin.singleton.enums.SingletonOpEnum;

/**
 * Author: Xiyao Li
 * Date: 2024/9/18 2:06
 */
public class TestSingleton {
    /**
     * 在此处选择单例模式
     */
    public static final SingletonOpEnum SINGLETON_OP = SingletonOpEnum.INNER_CLAZZ;

    public static void main(String[] args) {
        SingletonImpl singleton1;
        SingletonImpl singleton2;
        switch (SINGLETON_OP) {
            case EAGER -> {
                singleton1 = SingletonEager.getInstance();
                singleton2 = SingletonEager.getInstance();
            }
            case LAZY -> {
                singleton1 = SingletonLazy.getInstance();
                singleton2 = SingletonLazy.getInstance();
            }
            case DCL -> {
                singleton1 = SingletonDCL.getInstance();
                singleton2 = SingletonDCL.getInstance();
            }
            case INNER_CLAZZ -> {
                singleton1 = SingletonInnerClazz.getInstance();
                singleton2 = SingletonInnerClazz.getInstance();
            }
            default -> {
                singleton1 = SingletonLazy.getInstance();
                singleton2 = SingletonLazy.getInstance();
            }
        }
        System.out.println(singleton1.getName());
        System.out.println(singleton2.getName());
        System.out.println("singleton1 == singleton2 = " + (singleton1 == singleton2));
    }
}
