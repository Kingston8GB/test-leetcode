package com.kirin.singleton;

import com.kirin.singleton.base.SingletonImpl;

/**
 * 单例模式-饿汉式
 * Author: Xiyao Li
 * Date: 2024/9/18 1:54
 */
public class SingletonEager extends SingletonImpl {
    private static final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}
