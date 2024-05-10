package haos.demo.mq.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//@Configuration
public class RabbitConfig {

//    消费者配置
    @Bean(name = "firstConnectionFactory")
    @Primary
    public ConnectionFactory firstConnectionFactory(
            @Value("${spring.rabbitmq.first.addresses}") String addresses,
            @Value("${spring.rabbitmq.first.username}") String username,
            @Value("${spring.rabbitmq.first.password}") String password,
            @Value("${spring.rabbitmq.first.virtual-host}") String virtualHost
    ) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }



    @Bean(name = "firstRabbitTemplate")
    @Primary
    public RabbitTemplate firstRabbitTemplate(
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
        return firstRabbitTemplate;
    }




    @Bean(name = "firstFactory")
    public SimpleRabbitListenerContainerFactory firstFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

//      生产者配置
    public final static String TOPIC_EXCHANGE = "haos-exchange";

    /**
     * topic队列1
     */
    public final static String TOPIC_QUEUE_ONE = "topic.queue.test1";

    /**
     * topic队列2
     */
    public final static String TOPIC_QUEUE_TWO = "topic.queue.test2";

    /**
     * 创建Topic Exchange交换机也叫模糊匹配交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder
                .topicExchange(TOPIC_EXCHANGE)
                // 开启持久化
                .durable(true)
                .build();
    }

//    /**
//     * 创建队列 1
//     */
//    @Bean
//    public Queue topicOneQueue() {
//        return QueueBuilder
//                .durable(TOPIC_QUEUE_ONE)
//                .build();
//    }
//
//    /**
//     * 创建队列 2
//     */
//    @Bean
//    public Queue topicTwoQueue() {
//        return QueueBuilder
//                .durable(TOPIC_QUEUE_TWO)
//                .build();
//    }
//
//    /**
//     * 确定绑定关系
//     */
////    @Bean
////    public Binding topicOneBinding(@Qualifier("topicOneQueue") Queue topicQueue, @Qualifier("topicExchange") TopicExchange topicExchange) {
////        return BindingBuilder.bind(topicQueue).to(topicExchange).with("hao.n1.test");
////    }
//
//    @Bean
//    public Binding topicTwoBinding(@Qualifier("topicTwoQueue") Queue topicQueue, @Qualifier("topicExchange") TopicExchange topicExchange) {
//        return BindingBuilder.bind(topicQueue).to(topicExchange).with("hao.test");
//    }


}