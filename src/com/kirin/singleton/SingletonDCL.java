package com.kirin.singleton;

import com.kirin.singleton.base.SingletonImpl;

import java.util.Objects;

/**
 * 单例模式-双重校验锁
 * Author: Xiyao Li
 * Date: 2024/9/18 1:54
 */
public class SingletonDCL extends SingletonImpl {
    private static volatile SingletonDCL INSTANCE = null;

    private SingletonDCL(){}

    public static SingletonDCL getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (SingletonDCL.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new SingletonDCL();
                }
            }
        }
        return INSTANCE;
    }

}
