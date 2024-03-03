package prev;

import java.util.HashMap;
import java.util.Map;

public class Test2342 {
    public int maximumSum(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int key = getDigitSum(nums[i]);
            if(!map.containsKey(key)) {
                map.put(key, new int[]{nums[i],-1});
            }else{
                int[] value = map.get(key);
                if(nums[i] > value[0]){
                    value[1] = value[0];
                    value[0] = nums[i];
                }else if(nums[i] > value[1]){
                    value[1] = nums[i];
                }
                map.put(key,value);
            }

        }
        int res = -1;
        for(int key : map.keySet()) {
            int[] value = map.get(key);
            if(value[1] != -1){
                res = Math.max(res,value[0] + value[1]);
            }
        }
        return res;

    }
    public int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            int temp = num % 10;
            sum += temp;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Test2342 test2342 = new Test2342();
        int maximumSum = test2342.maximumSum(new int[]{18, 43, 36, 13, 7});
        System.out.println("maximumSum = " + maximumSum);
    }
}
