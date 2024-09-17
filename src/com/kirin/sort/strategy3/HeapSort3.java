package com.kirin.sort.strategy3;

import com.kirin.sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/9/1 5:58
 */
public class HeapSort3 implements MySort {
    // 实现 MySort 接口

    @Override
    public int[] sort(int[] nums) {
        // 接受一个整数数组并返回排序后的数组

        int n = nums.length; // 获取数组的长度
        heapify(nums); // 将数组转换为最大堆

        // 从最后一个元素开始向前进行交换和下沉操作
        for(int i = n - 1; i >= 0; ) {
            swap(nums, 0, i); // 将堆顶元素（最大值）与当前最后一个元素交换
            i--; // 减小 i，表示堆的有效范围缩小
            siftDown(nums, 0, i); // 对新的堆顶元素进行下沉操作，维护堆的性质
        }

        return nums; // 返回排序后的数组
    }

    private void siftDown(int[] nums, int i, int end) {
        // 从索引 i 开始向下调整堆，直到索引不再在有效范围内
        while(2 * i + 1 <= end) { // 确保左子节点存在
            int j = 2 * i + 1; // 左子节点索引
            // 如果右子节点存在且大于左子节点，则选择右子节点
            if(j + 1 <= end && nums[j+1] > nums[j]) {
                j++; // j 指向右子节点
            }
            // 如果当前节点小于子节点，交换它们
            if(nums[j] > nums[i]) {
                swap(nums, i, j); // 交换当前节点与较大的子节点
                i = j; // 更新 i 为 j，继续向下调整
            } else {
                break; // 如果不需要交换，退出循环
            }
        }
    }

    private void heapify(int[] nums) {
        // 将数组转换为最大堆
        for(int i = (nums.length - 1) / 2; i >= 0; i--) {
            // 从最后一个非叶子节点开始，逐个调用 siftDown
            siftDown(nums, i, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        // 交换数组中两个元素的值
        int temp = nums[i]; // 保存 nums[i] 的值
        nums[i] = nums[j]; // 将 nums[j] 赋值给 nums[i]
        nums[j] = temp; // 将保存的值赋回 nums[j]
    }
}
