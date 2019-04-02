package com.sicredi.api.exception;

public class PautaNaoVotadaException extends VotacaoRuntimeException {
	private static final long serialVersionUID = 7061238626591644016L;
	
	private static final String msgPautaNaoVotada = "Pauta ainda não possui votos.";

	public PautaNaoVotadaException() {
		super(msgPautaNaoVotada);
	}

}
