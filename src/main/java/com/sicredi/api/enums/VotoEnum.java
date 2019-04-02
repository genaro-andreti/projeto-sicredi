package com.sicredi.api.enums;

import lombok.Getter;

@Getter
public enum VotoEnum {
	
	SIM("Sim"), NAO("Não");
	
	private VotoEnum(String valor) {
		this.valor = valor;
	}
	
	private String valor;
	
}
