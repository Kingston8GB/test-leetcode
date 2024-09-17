package com.kirin.sort;

import com.kirin.sort.enums.StrategyOpEnum;
import com.kirin.sort.strategy1.*;
import com.kirin.sort.strategy2.HeapSort2;
import com.kirin.sort.strategy2.MergeSort2;
import com.kirin.sort.strategy2.QuickSort2;
import com.kirin.sort.strategy3.HeapSort3;
import com.kirin.sort.strategy3.MergeSort3;
import com.kirin.sort.strategy3.QuickSort3;

import java.util.Objects;

/**
 * 策略模式管理器
 * Author: Xiyao Li
 * Date: 2024/2/23 2:00
 */
public class SortManager {
    private static SortManager sortManager;
    private MySort mySort;
    public int[] sort(int[] nums, StrategyOpEnum op){
        switch (op) {
            case INSERTION_SORT -> mySort = new InsertionSort();
            case SELECTION_SORT -> mySort = new SelectionSort();
            case SHELL_SORT -> mySort = new ShellSort();
            case MERGE_SORT -> mySort = new MergeSort();
            case QUICK_SORT -> mySort = new QuickSort();
            case HEAP_SORT -> mySort = new HeapSort();
            default -> mySort = new BubbleSort();
        }
        return mySort.sort(nums);
    }

    public int[] sort2(int[] nums, StrategyOpEnum op){
        switch (op) {
            case MERGE_SORT -> mySort = new MergeSort2();
            case HEAP_SORT -> mySort = new HeapSort2();
            default -> mySort = new QuickSort2();
        }
        return mySort.sort(nums);
    }

    public int[] sort3(int[] nums, StrategyOpEnum op){
        switch (op) {
            case MERGE_SORT -> mySort = new MergeSort3();
            case HEAP_SORT -> mySort = new HeapSort3();
            default -> mySort = new QuickSort3();
        }
        return mySort.sort(nums);
    }

    public MySort getMySort() {
        return mySort;
    }

    public void setMySort(MySort mySort) {
        this.mySort = mySort;
    }

    private SortManager(){}

    public static SortManager getManagerInstance() {
        if(Objects.isNull(sortManager)) {
            sortManager = new SortManager();
        }
        return sortManager;
    }
}
