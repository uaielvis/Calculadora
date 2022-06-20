package br.com.wit.calculatorapi.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperacaoCalculatorDTO {

	private BigDecimal valueA;

	private BigDecimal valueB;

	private String operacao;
	
	public OperacaoEnum getOperacaoEnum() {
		for(OperacaoEnum op : OperacaoEnum.values()) {
			if(op.name().equals(getOperacao())) {
				return op;
			}
		}
		throw new RuntimeException("Operation not found");
	}
	
	public enum OperacaoEnum {
		SUM, SUBTRACT, MULTIPLY, DIVIDE;
	}

}
