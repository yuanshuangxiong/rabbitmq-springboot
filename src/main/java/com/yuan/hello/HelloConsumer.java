package com.yuan.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消费者 默认创建一个持久化，非独占，不是自动删除的队列,durable = "false",autoDelete = "true"
@Component
@RabbitListener(queuesToDeclare=@Queue(value="hello"))//监听来自hello队列的消息,设置不持久化
public class HelloConsumer {
    @RabbitHandler
    public void receivel(String message){
        System.out.println("message="+message);
    }
}
