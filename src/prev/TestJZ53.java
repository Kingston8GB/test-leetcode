package prev;

public class TestJZ53 {
    public static int search(int[] nums, int target) {
        int res = 1;
        int left = 0;
        int right = nums.length - 1;
        int targetPos = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                targetPos = mid;
                break;
            }
        }
        if(targetPos == -1){
            return 0;
        }
        int offset = 1;
        while((targetPos - offset) > 0 && nums[targetPos - offset] == target){
            res++;
            offset++;
        }
        offset = 1;
        while((targetPos + offset) < nums.length && nums[targetPos + offset] == target){
            res++;
            offset++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int target = 1;
        System.out.println(search(nums,target));
    }
}
