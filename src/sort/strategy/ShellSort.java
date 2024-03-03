package sort.strategy;

import sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 2:28
 */
public class ShellSort implements MySort {
    @Override
    public int[] sort(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        while(gap > 0) {
            for(int i = gap; i < n; i += gap) {
                int temp = nums[i];
                int j = i - gap;
                while(j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }

            gap /= 2;
        }
        return nums;
    }
}
