package prev;

import java.util.ArrayList;
import java.util.List;

public class Test100049 {
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        int maxValue = Integer.MIN_VALUE;
//        int maxValueIndex = -1;
        List<Integer> maxValueIndexList = new ArrayList<>();
        for(int i = 0; i < maxHeights.size(); i++){
            if(maxValue < maxHeights.get(i)){
                maxValue = maxHeights.get(i);
                maxValueIndexList.clear();
                maxValueIndexList.add(i);
            }else if(maxValue == maxHeights.get(i)){
                maxValueIndexList.add(i);
            }
        }


        // int minValueLeft = Integer.MAX_VALUE;
        // int minValueLeftIndex = -1;
        // for(int i = 0; i < maxValueIndex; i++){
        //     minValueLeft = Math.min(minValueLeft, maxHeights.get(i));
        //     minValueLeftIndex = i;
        // }
        // if(minValueLeftIndex != 0){
        //     for(int i = 0; i < minValueLeftIndex; i++){
        //         sum += maxHeights.get(minValueLeftIndex);
        //     }
        // }

        // if(maxValueIndex >= 1){
        //     for(int i = maxValueIndex - 1; i >= minValueLeftIndex; i--){
        //         if(maxHeights.get(i) < pre){
        //             pre = maxHeights.get(i);
        //         }
        //         sum += pre;
        //     }
        // }




//        long res = Integer.MIN_VALUE;
//        for(int k = 0; k < maxValueIndexList.size(); k++){
//            long sum = maxValue;
//            int maxValueIndex = maxValueIndexList.get(k);
        long res = Integer.MIN_VALUE;
        for(int k = 0; k < maxHeights.size(); k++){
            long sum = maxHeights.get(k);
            int maxValueIndex = k;
            int pre = maxHeights.get(k);
            if(maxValueIndex >= 1){
                for(int i = maxValueIndex - 1; i >= 0; i--){
                    if(maxHeights.get(i) < pre){
                        pre = maxHeights.get(i);
                    }
                    sum += pre;
                }
            }




            // int minValueRight = Integer.MAX_VALUE;
            // int minValueRightIndex = maxHeights.size();
            // for(int i = maxHeights.size() - 1; i > maxValueIndex; i--){
            //     minValueRight = Math.min(minValueRight, maxHeights.get(i));
            //     minValueRightIndex = i;
            // }
            // if(minValueLeftIndex != maxHeights.size() - 1){
            //     for(int i = maxHeights.size() - 1; i > minValueRightIndex; i--){
            //         sum += maxHeights.get(minValueRightIndex);
            //     }
            // }
            // // for(int i = minValueRightIndex; i > maxValueIndex; i++){
            // //     sum += maxHeights.get(i);
            pre = maxValue;
            if(maxValueIndex < maxHeights.size() - 1){
                for(int i = maxValueIndex + 1; i < maxHeights.size(); i++){
                    if(maxHeights.get(i) < pre){
                        pre = maxHeights.get(i);
                    }
                    sum += pre;
                }
            }
            res = Math.max(sum,res);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

//    [3,6,3,5,5,1,2,5,5,6]
        integers.add(5);
        integers.add(2);
        integers.add(4);
        integers.add(4);

        long sum = maximumSumOfHeights(integers);
        System.out.println(sum);
    }
}
