package com.yuan;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RabbitmqSpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //直连模型
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");

    }

    //工作队列模型
    @Test
    public void testWork(){
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("work",i+"work模型");
        }
    }
    //广播 fanout
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","hello world");
    }
    //路由 direct
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }
    //topic 动态路由
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 路有消息");
    }

    @Test
    void contextLoads() {

    }

}
