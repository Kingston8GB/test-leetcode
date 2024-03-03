package sort.strategy;

import sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 2:28
 */
public class SelectionSort implements MySort {
    @Override
    public int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int maxValue = nums[n - i - 1];
            int maxValueIdx = n - i - 1;
            for (int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[maxValueIdx]) {
                    maxValueIdx = j;
                    maxValue = nums[j];
                }
            }
            int temp = nums[maxValueIdx];
            nums[maxValueIdx] = nums[n - i - 1];
            nums[n - i - 1] = temp;

        }
        
        return nums;
    }
}
