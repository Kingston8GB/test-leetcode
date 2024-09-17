package com.kirin.singleton.base;

/**
 * 单例模式-父类
 * Author: Xiyao Li
 * Date: 2024/9/18 1:56
 */
public interface ISingleton {
    default String getName() {
        return ISingleton.class.getName();
    }
}
