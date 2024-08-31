package ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 限流算法-令牌桶
 */
public class TokenBucket {
    private final int capacity;
    private int tokens;
    private final long refillRate; // 每秒填充的令牌数
    private long lastRefillTimestamp;

    public TokenBucket(int capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume(int amount) {
        refill();
        if (tokens >= amount) {
            tokens -= amount;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTimestamp;
        int refilledTokens = (int) (elapsedTime * refillRate / 1000);
        tokens = Math.min(capacity, tokens + refilledTokens);
        lastRefillTimestamp = now;
    }

    public static void main(String[] args) {
        TokenBucket bucket = new TokenBucket(10, 1); // 容量为10，每秒填充1个令牌
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