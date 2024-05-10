package haos.demo.common.util.helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public final class RedisLockHelper {

    private static final String UNLOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public boolean unlock(String key, String value) {
        Long effect = (Long) redisTemplate.execute(RedisScript.of(UNLOCK_SCRIPT, Long.class), Arrays.asList(key), value);
        if (Objects.equals(effect, 0L)) {
            log.info("The lock [{}-{}] 已经过期", key, value);
            return Boolean.FALSE;
        } else {
            log.info("The lock [{}-{}] 释放成功", key, value);
            return Boolean.TRUE;
        }
    }

    /**
     * 上锁
     * @param key  lock
     * @param value 用于确认上锁者身份
     * @param timeout  缓存过期时间，单位为s
     */
    public boolean lock(String key, String value, int timeout) {
        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.SECONDS);
        if (isLock) {
            log.info("The lock [{}] 上锁成功", key);
            return Boolean.TRUE;
        } else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("The lock [{}] 被占用，重新上锁 >>> {}", key, LocalDateTime.now());
            return lock(key, value, timeout);
        }
    }

    public boolean lock(String key, String value) {
        return lock(key, value, 10);
    }
}