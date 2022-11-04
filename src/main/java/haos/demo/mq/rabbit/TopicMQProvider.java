package haos.demo.mq.rabbit;


import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TopicMQProvider {

    private final RabbitTemplate rabbitTemplate;

    public void sendTopicMsg(String msg, String key) {
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, key, msg);
    }

}
