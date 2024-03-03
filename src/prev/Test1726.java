package prev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1726 {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j],0) + 1);
            }
        }
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value <= 1){
                continue;
            }
            int combination = combine(value,2);
            res += 8 * combination;
        }
        return res;
    }

    public int combine(int n, int m){
        int up = 1;
        int down = 1;
        for(int i = n; i > n-m; i--){
            up *= i;
        }
        for(int i = m; i >=1; i--){
            down *= i;
        }
        return up / down;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,5,10};

        Test1726 test1726 = new Test1726();

        int res = test1726.tupleSameProduct(nums);
        System.out.println(res);

    }
}
