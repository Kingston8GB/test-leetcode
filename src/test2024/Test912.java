package test2024;

import java.util.Arrays;
import java.util.Random;

/**
 * 手撕快速排序
 * Author: Xiyao Li
 * Date: 2024/2/6 1:14
 */
public class Test912 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,10,2,-5,5,9};
        Test912 test912 = new Test912();
        test912.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right){
            int pos = posSelect(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int posSelect(int[] nums, int left, int right) {

        int pos = new Random().nextInt(right - left + 1) + left;
        swap(nums, pos, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for(int j = left; j < right; j++) {
            if(nums[j] <= pivot){
                swap(nums, i ,j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
