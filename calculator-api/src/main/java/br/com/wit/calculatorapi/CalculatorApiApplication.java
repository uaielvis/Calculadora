package br.com.wit.calculatorapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class CalculatorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApiApplication.class, args);
	}

}
