package test2024;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Xiyao Li
 * Date: 2024/2/5 2:48
 */
public class Test1696 {
    class MyQueue {
        Deque<Integer> deque;

        MyQueue() {
            this.deque = new LinkedList<>();
        }

        void poll(int x) {
            if(!deque.isEmpty() && x == deque.peek()) {
                deque.pollFirst();
            }
        }

        void offer(int x) {
            while(!deque.isEmpty() && x > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(x);
        }

        int peek() {
            return deque.peekFirst();
        }
    }
    MyQueue queue;
    public int maxResult(int[] nums, int k) {
        queue = new MyQueue();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = maxInPrevK(dp, i, k) + nums[i];
        }
        return dp[dp.length - 1];
    }

    public int maxInPrevK(int[] nums, int i, int k) {
        if(i - 1 - k >= 0) {
            queue.poll(nums[i-1-k]);
        }
        queue.offer(nums[i-1]);
        return queue.peek();
    }

    public static void main(String[] args) {
        Test1696 test1696 = new Test1696();
        System.out.println("maxResult = " + test1696.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
    }
}
