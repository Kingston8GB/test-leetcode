package com.kirin.sort.enums;

/**
 * 选用哪套策略，与策略的包名一致
 * Author: Xiyao Li
 * Date: 2024/9/1 6:02
 */
public enum StrategyGroupEnum {
    STRATEGY_GROUP_1(1),
    STRATEGY_GROUP_2(2),
    STRATEGY_GROUP_3(3),
    ;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    StrategyGroupEnum(int code) {
        this.code = code;
    }
}
