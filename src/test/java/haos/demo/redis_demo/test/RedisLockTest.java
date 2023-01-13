package haos.demo.redis_demo.test;


import haos.demo.util.helper.RedisLockHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLockTest {

    @Resource
    private RedisLockHelper redisLockHelper;

    @Test
    public void testFirst() {
        service("a");
    }

    @Test
    public void testSecond() {
        service("b");
    }

    @Test
    public void testThird() {
        service("c");
    }

    private void service(String caller) {
        //配置锁，设置随机uuid进行验证防止误删
        String uuid = "uuid" + caller;
        //设置过期时间为10s
        boolean lock = redisLockHelper.lock("lock", uuid);
        if (lock) {
            if (caller == "a") {
                System.out.println("执行复杂业务逻辑～");
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("执行简单业务逻辑~");
            }

            //释放锁，del，保证锁必须被释放-->当业务执行时间小与过期时间时需要释放锁
            redisLockHelper.unlock("lock", uuid);
        }
    }
}
