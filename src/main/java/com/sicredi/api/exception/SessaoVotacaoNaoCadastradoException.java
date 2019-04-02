package com.sicredi.api.exception;

public class SessaoVotacaoNaoCadastradoException extends VotacaoRuntimeException {
	private static final long serialVersionUID = 2016370870082120260L;
	
	private static final String msgSessaoVotacaoNaoCadastrada = "Sessão de Votação não cadastrada.";

	public SessaoVotacaoNaoCadastradoException() {
		super(msgSessaoVotacaoNaoCadastrada);
	}

}
