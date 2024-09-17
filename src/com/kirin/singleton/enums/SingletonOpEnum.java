package com.kirin.singleton.enums;

/**
 * 单例模式方法的枚举类
 * Author: Xiyao Li
 * Date: 2024/9/18 2:11
 */
public enum SingletonOpEnum {
    EAGER(1, "饿汉式"),
    LAZY(2, "懒汉式"),
    DCL(3, "双重校验锁"),
    INNER_CLAZZ(4, "静态内部类"),

    ;
    int code;
    String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    SingletonOpEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
