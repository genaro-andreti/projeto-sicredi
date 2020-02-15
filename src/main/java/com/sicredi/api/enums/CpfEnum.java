package com.sicredi.api.enums;

import lombok.Getter;

@Getter
public enum CpfEnum {
	
	ABLE_TO_VOTE("Voto permitido"), UNABLE_TO_VOTE("Voto negado"), STATUS_404("Not found");
	
	private CpfEnum(String valor) {
		this.valor = valor;
	}
	
	private String valor;
}
