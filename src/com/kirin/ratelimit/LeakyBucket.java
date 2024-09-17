package com.kirin.ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 限流算法-漏桶
 */
public class LeakyBucket {
    private final int capacity;
    private int water;
    private final long refillRate; // 每秒填充的水量
    private long lastRefillTimestamp;

    public LeakyBucket(int capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume(int amount) {
        refill();
        if (water >= amount) {
            water -= amount;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTimestamp;
        int refilledAmount = (int) (elapsedTime * refillRate / 1000);
        water = Math.min(capacity, water + refilledAmount);
        lastRefillTimestamp = now;
    }

    public static void main(String[] args) {
        LeakyBucket bucket = new LeakyBucket(10, 1); // 容量为10，每秒填充1个单位
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            if (bucket.tryConsume(1)) {
                System.out.println("Request processed");
            } else {
                System.out.println("Request rejected");
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}