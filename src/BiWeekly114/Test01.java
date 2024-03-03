package BiWeekly114;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test01 {


    public static int main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        int k = 5;
        Set<Integer> set  = new HashSet<>();
        for(int i = 0; i < k; i++){
            set.add(i+1);
        }
        int[] numsArray = nums.stream().mapToInt(x-> x).toArray();
        int res = 0;
        for(int i = numsArray.length - 1; i >= 0; i--){
            set.remove(numsArray[i]);
            res++;
            if(set.isEmpty()){
                return res;
            }
        }
        return -1;
    }
}
