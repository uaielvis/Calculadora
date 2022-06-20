package br.com.wit.calculatorapi.listener;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wit.calculatorapi.config.RabbitMQConfig;
import br.com.wit.calculatorapi.dto.OperacaoCalculatorDTO;
import br.com.wit.calculatorapi.service.OperacaoService;

@Component
public class CalculatorApiListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorApiListener.class);
	@Autowired
	private OperacaoService operacaoService;
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public BigDecimal receive(Message message , @Header("token") String token) {
    	
    	String fileBody= new String(message.getBody());
    	
    	LOGGER.info("[Project Calculator API] - method receive [json {} | token {}]", fileBody, token);
		try {
			ObjectMapper mapper = new ObjectMapper();
			OperacaoCalculatorDTO operacaoDto = mapper.readValue(fileBody, OperacaoCalculatorDTO.class);
			LOGGER.info("[Project Calculator API] - method receive [OperacaoCalculatorDTO {}]", operacaoDto.toString());
			return operacaoService.calculate(operacaoDto);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Erro ao converter objeto em json", e);
		}
    }

}

