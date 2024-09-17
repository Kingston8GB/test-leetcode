package com.kirin.sort.enums;

/**
 * 选用哪个排序方法
 * Author: Xiyao Li
 * Date: 2024/9/1 6:05
 */
public enum StrategyOpEnum {
    BUBBLE_SORT(1, "bubble"),
    HEAP_SORT(2, "heap"),
    INSERTION_SORT(3, "insertion"),
    MERGE_SORT(4, "merge"),
    QUICK_SORT(5, "quick"),
    SELECTION_SORT(6, "select"),
    SHELL_SORT(7, "shell"),
    /**
     * 默认排序方法，具体使用哪种需要在SortManager指定
     */
    DEFAULT_SORT(8, "default"),
    ;
    private Integer code;
    private String name;

    StrategyOpEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
