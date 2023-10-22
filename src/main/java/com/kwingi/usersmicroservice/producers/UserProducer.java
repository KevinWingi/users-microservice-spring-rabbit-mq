package com.kwingi.usersmicroservice.producers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwingi.usersmicroservice.dtos.EmailRecordDTO;
import com.kwingi.usersmicroservice.entities.UserEntity;

@Component
public class UserProducer {

	@Autowired private RabbitTemplate rabbitTemplate;
	
	@Autowired private ObjectMapper mapper;
	
	@Value("${mbroker.queue.email}")
	private String routingKey;
	
	public void sendWelcomeEmail(UserEntity user) {
		String subject = String.format("Welcome %s", user.getName());
		String content = String.format("Hello %s, very happy to have you a board enjoy the journey!", user.getName());
		Set<String> tos = new HashSet<>(Set.of(user.getEmail()));
				
		var email = new EmailRecordDTO(subject, content, tos, null, null);
		try {
			String payload = mapper.writeValueAsString(email);
			rabbitTemplate.convertAndSend(routingKey, payload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}		
	}
	
}	
