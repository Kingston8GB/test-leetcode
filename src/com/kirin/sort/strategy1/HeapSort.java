package com.kirin.sort.strategy1;

import com.kirin.sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 2:28
 */
public class HeapSort implements MySort {
    @Override
    public int[] sort(int[] nums) {

        int n = nums.length;
        heapify(nums);

        for(int i = n - 1; i >= 0; ) {
            swap(nums, 0, i);
            i--;
            siftDown(nums, 0, i);
        }

        return nums;
    }

    private void siftDown(int[] nums, int i, int end) {
        while(2 * i + 1 <= end) {
            int j = 2 * i + 1;
            if(j + 1 <= end && nums[j+1] > nums[j]) {
                j++;
            }
            if(nums[j] > nums[i]) {
                swap(nums, i, j);
                i = j;
            }else{
                break;
            }
        }
    }

    private void heapify(int[] nums) {
        for(int i = (nums.length - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

