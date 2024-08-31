package prev;

import java.util.*;

public class Test8021 {
    public static int minOperations(List<Integer> nums, int target) {
        int[] numsArr = nums.stream().mapToInt(x -> x).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < numsArr.length; j++) {

            for (int i = 0; i <= 30; i++) {
                if ((int)Math.pow(2, i) == numsArr[j]) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        List<Integer> targetFactor = new ArrayList<>();
        for (int i = 0; i <= 30 && target>0; i++) {
            if((int)Math.pow(2,i) > target){
                target -= (int)Math.pow(2,i-1);
                targetFactor.add(i-1);
                i = 0;
            }
        }
        int[] targetFactorArr = targetFactor.stream().mapToInt(x -> x).toArray();
        Arrays.sort(targetFactorArr);
        int res = 0;
        for(int i = 0; i < targetFactorArr.length; i++){
            if(!map.containsKey(targetFactorArr[i])){
                int temp = targetFactorArr[i] + 1;

                while(true){
                    if(map.containsKey(temp)){
                        res += temp - targetFactorArr[i];
                        map.put(temp,map.get(temp) - 1);
                        map.put(temp -1, map.getOrDefault(temp -1,0) + 2);
//                        map.put(temp / 2, map.getOrDefault(temp / 2,0) + 1);
                        break;
                    }
                    temp+=1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(32);
        nums.add(1);
        nums.add(2);
        int target = 12;
        System.out.println(minOperations(nums, target));
    }
}
