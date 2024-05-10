package haos.demo.redis_demo.test;

import haos.demo.thread.completable_future.FutureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    @Resource
    private FutureService futureService;

    @Resource(name = "comThreadPool")
    private ExecutorService comThreadPool;

    @Test
    public void test() {
        futureService.demo();
    }

    @Test
    public void test2() {
        CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行着呢");
            return "啊哈哈";
        }, comThreadPool).handle((e,r)->{
            System.out.println(r);
            System.out.println(e);
            return r;
        });
        System.out.println("main out");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
