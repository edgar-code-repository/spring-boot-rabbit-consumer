package com.example.demo.rabbit.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.rabbit.consumer.config.RabbitConfiguration;
import com.example.demo.rabbit.consumer.dto.MessageReceived;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@RabbitListener(queues=RabbitConfiguration.RABBIT_QUEUE)
public class RabbitListenerService {

	static final Logger logger = LoggerFactory.getLogger(RabbitListenerService.class);
	
	@RabbitHandler
	public void processMessage(String strMessage) throws Exception  {
		logger.debug("[RabbitListenerService][processMessage][INICIO]");
		logger.debug(String.format("[RabbitListenerService][processMessage][Message received from RabbitMQ: %s]", strMessage));
		
		ObjectMapper objectMapper = new ObjectMapper();
		MessageReceived messageReceived = objectMapper.readValue(strMessage, MessageReceived.class);
		
		logger.debug(String.format("[RabbitListenerService][processMessage][Message parsed by Jackson: %s]", messageReceived));
				
		logger.debug("[RabbitListenerService][processMessage][FIN]");
	}
	
}
