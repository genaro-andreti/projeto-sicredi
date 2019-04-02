package com.sicredi.api.exception;

public class AssociadoNaoCadastradoException extends VotacaoRuntimeException {
	private static final long serialVersionUID = -7948218417613890439L;
	
	private static final String msgAssociadoNaoCadastrada = "Associado não cadastrado.";
	
	public AssociadoNaoCadastradoException() {
		super(msgAssociadoNaoCadastrada);
	}

}
