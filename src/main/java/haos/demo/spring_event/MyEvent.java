package haos.demo.spring_event;


import org.springframework.context.ApplicationEvent;

/**
 * 事件
 */

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }

}
