package com.dxl.example.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * @Program RabbitApplication
 * @Description
 * @Author duxl
 * @Create 2018/11/15 17:04
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.dxl.example.rabbit"})
public class RabbitApplication {
    //final static String queueName = "spring-boot";
   /* final static String queueName = "direct-queue";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    Binding direciBinding(Queue queue,DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("direct");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout-exchange");
    }*/

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class);

    }


}
