package com.kirin.ratelimit;

import java.util.concurrent.ArrayBlockingQueue;

public class TokenBucket {
    private ArrayBlockingQueue<Object> tokens;

    // 令牌桶容量
    private int capacity;

    // 令牌生成速率（每秒生成令牌数量）
    private int rate;

    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        tokens = new ArrayBlockingQueue<>(capacity);

        // 初始化令牌生成线程
        Thread tokenGenerator = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000 / rate); // 每秒生成 rate 个令牌
                    if (tokens.size() < capacity) {
                        tokens.put(new Object()); // 生成令牌并放入队列
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tokenGenerator.start();
    }

    // 处理请求
    public boolean allowRequest() {
        return tokens.poll() != null; // 尝试从令牌桶中取出一个令牌
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(10, 5); // 令牌桶容量为 10，每秒生成 5 个令牌

        for (int i = 0; i < 20; i++) {
            if (tokenBucket.allowRequest()) {
                System.out.println("Allowed - Request " + (i + 1));
            } else {
                System.out.println("Denied - Request " + (i + 1));
            }
        }
    }
}