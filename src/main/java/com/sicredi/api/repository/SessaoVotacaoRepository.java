package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sicredi.api.model.SessaoVotacao;

import reactor.core.publisher.Mono;

@Repository
public interface SessaoVotacaoRepository extends ReactiveMongoRepository<SessaoVotacao, String> {
	
	Mono<SessaoVotacao> getByPauta(String idPauta);

}
