package com.sicredi.api.exception;

public class SessaoVotacaoFechadaException extends VotacaoRuntimeException {
	private static final long serialVersionUID = -8645983888975405514L;
	
	private static final String msgSessaoVotacaoFechada = "Sessão de Votação está fechada.";
	
	public SessaoVotacaoFechadaException() {
		super(msgSessaoVotacaoFechada);
	}

}
