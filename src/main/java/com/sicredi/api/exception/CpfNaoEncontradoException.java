package com.sicredi.api.exception;

public class CpfNaoEncontradoException extends VotacaoRuntimeException {
	private static final long serialVersionUID = -727564067695262046L;

	private static final String msgCpfNaoEncontrado = "Not found";

	public CpfNaoEncontradoException() {
		super(msgCpfNaoEncontrado);
	}
}
