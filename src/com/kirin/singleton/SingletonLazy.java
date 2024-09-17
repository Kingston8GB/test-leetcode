package com.kirin.singleton;

import com.kirin.singleton.base.SingletonImpl;

import java.util.Objects;

/**
 * 单例模式-懒汉式
 * Author: Xiyao Li
 * Date: 2024/9/18 1:54
 */
public class SingletonLazy extends SingletonImpl {
    private static SingletonLazy INSTANCE = null;

    private SingletonLazy(){}

    public static synchronized SingletonLazy getInstance() {
        if(Objects.isNull(INSTANCE)) {
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }
}
