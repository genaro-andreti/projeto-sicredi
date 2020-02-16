package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sicredi.api.model.SessaoVotacao;

import reactor.core.publisher.Mono;

public interface SessaoVotacaoRepository extends ReactiveMongoRepository<SessaoVotacao, String> {
	
	Mono<SessaoVotacao> getByPauta(String idPauta);

}
