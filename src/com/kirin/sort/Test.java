package com.kirin.sort;

import com.kirin.sort.enums.StrategyGroupEnum;
import com.kirin.sort.enums.StrategyOpEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排序测试程序的入口
 * Author: Xiyao Li
 * Date: 2024/2/23 1:55
 */

public class Test {
    public static final StrategyOpEnum OP = StrategyOpEnum.QUICK_SORT;
    public static final SortManager SORT_MANAGER = SortManager.getManagerInstance();
    public static final StrategyGroupEnum STRATEGY_GROUP = StrategyGroupEnum.STRATEGY_GROUP_2;
    public static final Integer AMOUNT = 100000;

    public static void main(String[] args) {
//        构建一个由0-9按随机顺序组成的数组
        int[] nums = constructArray();
        int[] oldArray = Arrays.copyOf(nums, nums.length);

        long start = System.currentTimeMillis();
//        使用OP方法排序
        switch (STRATEGY_GROUP) {
            case STRATEGY_GROUP_1 -> nums = SORT_MANAGER.sort(nums, OP);
            case STRATEGY_GROUP_2 -> nums = SORT_MANAGER.sort2(nums, OP);
            case STRATEGY_GROUP_3 -> nums = SORT_MANAGER.sort3(nums, OP);
        }
        long end = System.currentTimeMillis();

//        打印排序结果
        printResult(oldArray, nums, start, end);
    }

    /**
     * 打印排序结果
     *
     * @param oldArray 排序前数组
     * @param newArray 排序后数组
     * @param start 开始时间
     * @param end 结束时间
     */
    private static void printResult(int[] oldArray, int[] newArray, long start, long end) {
        System.out.println(OP.getName() + " 耗时：" + String.format("%.4f", 1.0 * (end - start) / 1000) + "秒");
        System.out.print("排序前数组前100位：");
        for (int i = 0; i < 100; i++) {
            System.out.print(oldArray[i] + " ");
        }
        System.out.println();
        System.out.print("排序后数组前100位：");
        for (int i = 0; i < 100; i++) {
            System.out.print(newArray[i] + " ");
        }
    }

    /**
     * 构建一个由0-9按随机顺序组成的数组
     *
     * @return 随机数组
     */
    private static int[] constructArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
