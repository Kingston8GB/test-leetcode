package prev;

public class Test2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        if(nums.length == 1){
            return nums[0] % 2 == 0 ? 1: 0;
        }
        int left = 0;
        int right = 1;
        int res = 0;
        while(left < nums.length){
            while(left < nums.length && (nums[left] % 2 == 1 || nums[left] > threshold)){
                left++;
            }
            right = left+1;
            while(right < nums.length){
                if(nums[right] % 2 == nums[right-1] % 2 || nums[right] > threshold){
                    res = Math.max(res,right - left);
                    break;
                }
                right++;
            }
            if(right == nums.length){
                return right - left;
            }
            left++;

        }

        return res;
    }

    public static void main(String[] args) {
        Test2760 test2760 = new Test2760();
        int i = test2760.longestAlternatingSubarray(new int[]{2,3,3,10}, 18);
        System.out.println("i = " + i);
    }
}
