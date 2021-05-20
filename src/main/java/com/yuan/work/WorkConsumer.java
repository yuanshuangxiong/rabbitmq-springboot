package com.yuan.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))//创建一个消费者
    public void receive1(String message){
        System.out.println("message1="+message);
    }
    @RabbitListener(queuesToDeclare = @Queue("work"))//创建一个消费者
    public void receive2(String message){
        System.out.println("message2="+message);
    }
}
