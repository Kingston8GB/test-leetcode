package com.kirin.singleton.base;

import com.kirin.singleton.base.ISingleton;

/**
 * Author: Xiyao Li
 * Date: 2024/9/18 2:02
 */
public class SingletonImpl implements ISingleton {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
