package haos.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * common
     */
    @Bean("comThreadPool")
    public ThreadPoolExecutor commonThreadPool() {
        return new ThreadPoolExecutor(5, 30,
                200L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
    }
}
