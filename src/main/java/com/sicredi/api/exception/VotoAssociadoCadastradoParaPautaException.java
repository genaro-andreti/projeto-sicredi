package com.sicredi.api.exception;

public class VotoAssociadoCadastradoParaPautaException extends VotacaoRuntimeException {
	private static final long serialVersionUID = 3355249485129704943L;
	
	private static final String msgVotoCadastradoParaAssociado = "Associado já votou esta Pauta";

	public VotoAssociadoCadastradoParaPautaException() {
		super(msgVotoCadastradoParaAssociado);
	}

}
