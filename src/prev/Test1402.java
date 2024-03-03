package prev;

import java.util.stream.IntStream;

public class Test1402 {
    public int maxSatisfaction(int[] satisfaction) {
        int res = 0;
        int[] satisfactionSorted = IntStream.of(satisfaction).boxed().sorted((a, b)->Integer.compare(b,a)).mapToInt(Integer::intValue).toArray();
        int n = satisfactionSorted.length;
        int positiveNum = 0;
        for(int i = 0; i < n; i++){
            if(satisfactionSorted[i] < 0){
                positiveNum = i;
            }
        }
        for(int i = positiveNum; i <= n; i++){
            int tempRes = 0;
            for(int j = i; j >= 1; j--){
                tempRes += satisfactionSorted[i-j] * j;
            }
            res = Math.max(res,tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        Test1402 test1402 = new Test1402();
        int[] satisfaction = new int[]{-1,-8,0,5,-7};
        int res = test1402.maxSatisfaction(satisfaction);
        System.out.println("res = " + res);
    }
}
