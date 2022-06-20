package br.com.wit.calculatorapi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.wit.calculatorapi.dto.OperacaoCalculatorDTO;

@Service
public class OperacaoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperacaoService.class);
	
	public BigDecimal calculate(OperacaoCalculatorDTO operacaoDto) {
		LOGGER.info("[Project Calculator API] - method calculate [OperacaoCalculatorDTO {}]", operacaoDto.toString());
		switch (operacaoDto.getOperacaoEnum()) {
		case SUM:
			return operacaoDto.getValueA().add(operacaoDto.getValueB());
		case SUBTRACT:
			return operacaoDto.getValueA().subtract(operacaoDto.getValueB());
		case MULTIPLY:
			return operacaoDto.getValueA().multiply(operacaoDto.getValueB());
		case DIVIDE:
			return operacaoDto.getValueA().divide(operacaoDto.getValueB(), RoundingMode.HALF_EVEN);
		default:
			LOGGER.error("[Project Calculator API] - method calculate [Operation not found]");
			return BigDecimal.ZERO;
		}
	}

}
