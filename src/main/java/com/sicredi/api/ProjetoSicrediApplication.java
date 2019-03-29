package com.sicredi.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoSicrediApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjetoSicrediApplication.class);
	
	@Value("${msg.inicial}")
	private String msgInicial;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSicrediApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			log.info(this.msgInicial);
		};
	}

}
