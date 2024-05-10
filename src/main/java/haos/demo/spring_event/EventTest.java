package haos.demo.spring_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventTest {

    @Autowired
    private  ApplicationEventPublisher publisher;

    public void thing() {
        MyModel myModel = new MyModel("1号Model");
        MyEvent myEvent = new MyEvent(myModel);
        publisher.publishEvent(myEvent);
    }
}
