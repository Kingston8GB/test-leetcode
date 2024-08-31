package prev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class Test56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Deque<int[]> stack = new LinkedList<>();

        Arrays.sort(intervals,new IntervalComparator());
        for(int i = 0; i < intervals.length; i++){
            System.out.print(intervals[i][0] + " " + intervals[i][1]);
            System.out.println();
        }
        stack.offerLast(intervals[0]);

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] <= stack.peekLast()[1]){
                int[] preRange = stack.pollLast();
                int[] postRange = intervals[i];
                int[] newRange = {preRange[0], postRange[1]};
                stack.offerLast(newRange);
            }else{
                stack.offerLast(intervals[i]);
            }

        }

        int[][] res = new int[stack.size()][];
        int cnt = 0;
        while(!stack.isEmpty()){
            int[] temp = stack.pollFirst();
            res[cnt++] = temp;
        }
        return res;
    }

    static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] arr1, int[] arr2){
            int cmp = Integer.compare(arr1[0], arr2[0]);
            if(cmp != 0){
                return cmp;
            }
            return Integer.compare(arr1[1], arr2[1]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,4}};
        int[][] res = merge(intervals);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i][0] + " " + res[i][1]);
            System.out.println();
        }
    }
}
