package prev;

import java.util.Objects;

public class Test26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int slow = 1;
        int fast = 1;
        int res = nums.length;
        for(; fast < nums.length; fast++){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
                res--;
            }
//            fast++;
        }
        for(int i = 0; i < res; i++){
            System.out.print(nums[i]+ " ");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }

    static class Pair{
        int i;
        int j;
        public Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
