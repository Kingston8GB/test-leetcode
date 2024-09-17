package com.kirin.singleton;

import com.kirin.singleton.base.SingletonImpl;

/**
 * 单例模式-静态内部类
 * Author: Xiyao Li
 * Date: 2024/9/18 1:55
 */
public class SingletonInnerClazz extends SingletonImpl {
    private SingletonInnerClazz(){}

    private static class SingletonInnerClass {
        private static final SingletonInnerClazz INSTANCE = new SingletonInnerClazz();
    }

    public static SingletonInnerClazz getInstance() {
        return SingletonInnerClass.INSTANCE;
    }
}
