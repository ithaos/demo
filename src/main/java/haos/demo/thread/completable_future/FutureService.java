package haos.demo.thread.completable_future;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

@Component
@AllArgsConstructor
public class FutureService {

    @Resource(name = "comThreadPool")
    private ExecutorService pool;

    public void demo()  {

        //guava
        final Map<String, Integer> map =new HashMap<String, Integer>(){
            {
                put("key",0);
            }
        };

        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    synchronized (map){
                        map.put("key", map.get("key") + 1);
                    }
                } finally {
                    latch.countDown();
                }
            }, pool);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}

class Task implements Runnable {
    @Override
    public void run() {

    }
}