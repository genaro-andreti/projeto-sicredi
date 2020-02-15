package com.sicredi.api.exception;

public class CpfInvalidoParaVotoException extends VotacaoRuntimeException {
	private static final long serialVersionUID = -5874285619468659330L;
	
	private static final String msgCpfInvalidoParaVoto = "Cpf inválido para votação.";
	
	public CpfInvalidoParaVotoException() {
		super(msgCpfInvalidoParaVoto);
	}
}
