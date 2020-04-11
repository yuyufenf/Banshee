package com.gundam.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池控制
 * @author kampf
 * @date 2020/4/11 上午11:34
 */
public class ExecutorConfig {

    /** 设置核心线程数*/
    @Value("${executor.corePoolSize}")
    private int corePoolSize;
    /** 设置最大线程数*/
    @Value("${executor.maxPoolSize}")
    private int maxPoolSize;
    /** 设置队列容量*/
    @Value("${executor.queueCapacity}")
    private int queueCapacity;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        if (corePoolSize == 0 ){
            corePoolSize = 1;
        }
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        if (maxPoolSize == 0 ){
            maxPoolSize = 1;
        }
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        if (queueCapacity == 0 ){
            queueCapacity = 1;
        }
        this.queueCapacity = queueCapacity;
    }

    /**
     * 带拒绝策略的异步任务池
     * @return 任务池
     */
    @Bean
    public Executor gatewayLogAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(corePoolSize);
        executor.setAllowCoreThreadTimeOut(true);
        // 最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 配置队列大小
        executor.setQueueCapacity(queueCapacity);
        // 配置线程池前缀
        executor.setThreadNamePrefix("Gateway-Async-Log-");
        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 带拒绝策略的线程池
     * @return  Executor
     */
    @Bean
    public ThreadPoolTaskExecutor defaultTaskPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("Default-Async-Service-");
        // 设置拒绝策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
