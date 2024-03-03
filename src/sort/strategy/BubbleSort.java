package sort.strategy;

import sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 1:57
 */
public class BubbleSort implements MySort {
    @Override
    public int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }
}
