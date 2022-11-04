package haos.demo.redis_demo.test;

import haos.demo.redis_demo.model.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Test
    public void testStringSetKey() {
//        Model model = Model.builder().name("hs").age("22").build();
//        redisTemplate.opsForValue().set("hs", model);
//        try {
//            Thread.sleep(1000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(redisTemplate.opsForValue().get("queryPerson::zky"));
    }

}
