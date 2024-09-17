package com.kirin.sort.strategy1;

import com.kirin.sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 2:27
 */
public class InsertionSort implements MySort {
    @Override
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }
}
