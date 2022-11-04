package haos.demo.mq.rabbit;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 需要注意 :消费者消费消息的时候，发生异常情况，导致消息未确认，该消息会被重复消费(默认没有重复次数，即无限循环消费)，但可以通过设置重试次数以及达到重试次数之后的消息处理
 * @Author haos1
 * @Date 2022/10/26 16:06
 */
@Component
public class TopicMQConsumer {

    /**
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue("topic.queue.test1"),
            exchange = @Exchange(name = "haos-exchange", type = ExchangeTypes.TOPIC), key = "hao.n1.test"),
            containerFactory = "firstFactory")
    public void simpleMsg1(String msg) {
        System.out.println("topic模式 hao.n1.test 接收到消息 :" + msg);
        //int i = 1 / 0;
        //消费者消费消息的时候，发生异常情况，导致消息未确认，该消息会被重复消费(默认没有重复次数，即无限循环消费)，但可以通过设置重试次数以及达到重试次数之后的消息处理
    }

    /**
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.queue.test2"),
            exchange = @Exchange(name = "haos-exchange",type = ExchangeTypes.TOPIC), key = "hao.*.test"),
            containerFactory = "firstFactory")
    public void simpleMsg2(String msg) {
        System.out.println("topic模式 hao.*.test 接收到消息 :" + msg);
        //int i = 1 / 0;
        //消费者消费消息的时候，发生异常情况，导致消息未确认，该消息会被重复消费(默认没有重复次数，即无限循环消费)，但可以通过设置重试次数以及达到重试次数之后的消息处理
    }

}
