package br.com.wit.restapi.dto;

import java.math.BigDecimal;

import br.com.wit.restapi.enums.OperacaoEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class OperacaoRestDTO {
	
	private BigDecimal valueA;
	
	private BigDecimal valueB;
	
	private OperacaoEnum operacao;
	
}