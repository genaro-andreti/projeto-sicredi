package com.sicredi.api.service;

import java.util.Optional;

import com.sicredi.api.model.SessaoVotacao;

public interface SessaoVotacaoService {
	
	SessaoVotacao cadastrar(SessaoVotacao sessaoVotacao);
	
	Optional<SessaoVotacao> sessaoVotacaoCadastrado(Long idSessaoVotacao);

}
