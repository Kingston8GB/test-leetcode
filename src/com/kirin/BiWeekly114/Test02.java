package BiWeekly114;

import java.util.HashMap;
import java.util.Map;

public class Test02 {
    public static int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer num : map.keySet()) {
            int value = map.get(num);
            if(value == 1) {
                return -1;
            }else if(value == 2 || value == 3){
                res += 1;
            }else{
                if(value % 3 == 0){
                    res += value / 3;
                }else{
                    res += value / 3 + 1;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
