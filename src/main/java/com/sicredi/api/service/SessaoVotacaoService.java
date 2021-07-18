package com.sicredi.api.service;

import com.sicredi.api.model.SessaoVotacao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SessaoVotacaoService {
	
	Mono<SessaoVotacao> cadastrar(SessaoVotacao sessaoVotacao);
	
	Mono<SessaoVotacao> sessaoVotacaoCadastrado(String idSessaoVotacao);
	
	Mono<SessaoVotacao> getByPauta(String idPauta);
	
	Flux<SessaoVotacao> findAll();

}
