package sort;

import sort.strategy.*;

/**
 * 策略模式管理器
 * Author: Xiyao Li
 * Date: 2024/2/23 2:00
 */
public class SortManager {
    MySort mySort;
    public int[] sort(int[] nums, String op){
        switch (op) {
            case "insert" -> mySort = new InsertionSort();
            case "select" -> mySort = new SelectionSort();
            case "shell" -> mySort = new ShellSort();
            case "merge" -> mySort = new MergeSort();
            case "quick" -> mySort = new QuickSort();
            case "heap" -> mySort = new HeapSort();
            default -> mySort = new BubbleSort();
        }
        return mySort.sort(nums);
    }
}
