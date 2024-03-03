package prev;

import java.util.*;

public class Test100128 {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] nums3 = Arrays.copyOf(nums1,nums1.length);
        int[] nums4 = Arrays.copyOf(nums2,nums2.length);
        int end1 = nums1[nums1.length - 1];
        int end2 = nums2[nums2.length - 1];
//        boolean flag = true;
        int times1 = 0;

        for (int i = 0; i < nums1.length - 1; i++) {
            if (nums2[i] > end2) {
                if ((nums1[i] > end2) || (nums2[i] > end1)) {
                    return -1;
                }

                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
                times1++;

            }


        }

        int times2 = 1;
//        int t = nums3[nums3.length -1];
//        nums3[nums3.length -1] = nums4[nums4.length -1];
//        nums4[nums4.length -1] = t;
        int t = end2;
        end2 = end1;
        end1 = t;
//        times1++;
        for (int i = 0; i < nums3.length - 1; i++) {
            if (nums4[i] > end2) {
                if ((nums3[i] > end2) || (nums4[i] > end1)) {
                    return -1;
                }

                int temp = nums3[i];
                nums3[i] = nums4[i];
                nums4[i] = temp;
                times2++;

            }
            if(nums3[i] > end1){
                if ((nums4[i] > end2) || (nums3[i] > end1)) {
                    return -1;
                }

                int temp = nums4[i];
                nums4[i] = nums3[i];
                nums3[i] = temp;
                times2++;
            }
        }
        return Math.min(times1,times2);
    }

    public static void main(String[] args) {
        Test100128 test100128 = new Test100128();
        int[] nums1 = new int[]{2,3,4,5,9};
        int[] nums2 = new int[]{8,8,4,4,4};
//        int nums2 = new int[]{2,3,4,5,9};
        System.out.println(test100128.minOperations(nums1, nums2));
//        [2,3,4,5,9],[8,8,4,4,4]
    }

}
