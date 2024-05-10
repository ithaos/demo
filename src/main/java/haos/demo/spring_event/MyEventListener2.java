package haos.demo.spring_event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
@Component
public class MyEventListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        MyModel source = (MyModel) myEvent.getSource();
        System.out.println("监听器2收到并处理了事件："+source.getName() + "/" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("监听器2处理完毕"+Thread.currentThread().getName());
    }
}
