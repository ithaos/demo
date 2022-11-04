package haos.demo.redis_demo.test;

import haos.demo.completable_future.FutureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    @Resource
    private FutureService futureService;

    @Test
    public void test() {
        futureService.demo();
    }

    @Test
    public void test2() {
        Integer a = 129;
        Integer b = 129;

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
