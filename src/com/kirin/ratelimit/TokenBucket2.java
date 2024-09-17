package com.kirin.ratelimit;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Author: Xiyao Li
 * Date: 2024/9/1 13:44
 */
public class TokenBucket2 {
    private ArrayBlockingQueue<Object> bucket;

    private int capacity;

    private int putRate;

    public TokenBucket2(int capacity, int putRate) {
        this.capacity = capacity;
        this.putRate = putRate;
        this.bucket = new ArrayBlockingQueue<>(capacity);

        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000 / putRate);
                    if(bucket.size() < capacity) {
                        bucket.put(new Object());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public boolean allowRequest() {
        return Objects.nonNull(bucket.poll());
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket2 tokenBucket2 = new TokenBucket2(10, 5);
        Thread.sleep(2000);
        for (int i = 0; i < 20; i++) {
            if (tokenBucket2.allowRequest()) {
                System.out.println("Allowed - Request " + (i + 1));
            } else {
                System.out.println("Denied - Request " + (i + 1));
            }
        }
    }
}
