package com.kirin.sort.strategy3;

import com.kirin.sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/9/1 5:56
 */
public class QuickSort3 implements MySort {
    @Override
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        // complete code
        int i = low + 1;
        int j = high;
        while (true) {
            // 从左边找到大于或等于主元的元素
            while (i <= high && nums[i] < pivot) {
                i++;
            }

            // 从右边找到小于或等于主元的元素
            while (j >= low && nums[j] > pivot) {
                j--;
            }

            // 如果 i 和 j 没有交错，进行交换
            if (i < j) {
                swap(nums, i, j);
            } else {
                break; // i 和 j 交错，结束循环
            }
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
