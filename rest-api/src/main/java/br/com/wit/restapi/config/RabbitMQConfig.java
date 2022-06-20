package br.com.wit.restapi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
public static final String EXCHANGE_NAME = "calculator-exchange";
	
	public static final String ROUTING_KEY = "calculator-routingkey";
	
	public static final String QUEUE_NAME = "calculator-queue";
	
	
	@Bean
	Queue messagesQueue() {
	    return QueueBuilder.durable(QUEUE_NAME)
	      .build();
	}
	 
	@Bean
	DirectExchange messagesExchange() {
	    return new DirectExchange(EXCHANGE_NAME);
	}
	 
	@Bean
	Binding bindingMessages() {
	    return BindingBuilder.bind(messagesQueue()).to(messagesExchange()).with(QUEUE_NAME);
	}
   
}
