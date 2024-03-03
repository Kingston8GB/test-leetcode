package sort.strategy;

import sort.MySort;

/**
 * Author: Xiyao Li
 * Date: 2024/2/23 2:28
 */
public class MergeSort implements MySort {
    @Override
    public int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int n = nums.length;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(nums,0,left,0, left.length);
        System.arraycopy(nums,mid,right,0, right.length);

        sort(left);
        sort(right);

        merge(left, right, nums);

        return nums;
    }

    private void merge(int[] left, int[] right, int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                nums[k++] = left[i++];
            }else {
                nums[k++] = right[j++];
            }
        }
        while(i < left.length) {
            nums[k++] = left[i++];
        }
        while(j < right.length) {
            nums[k++] = right[j++];
        }
    }
}
