package haos.demo.redis_demo.test;

import haos.demo.mq.rabbit.TopicMQProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {

    @Resource
    private TopicMQProvider provider;


    @Test
    public void testSendMsg() {
        provider.sendTopicMsg("张玩怡是这个猪","hao.n1.test");
    }

}
