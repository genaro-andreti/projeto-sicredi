package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sicredi.api.model.Voto;

import reactor.core.publisher.Flux;

@Repository
public interface VotoRepository extends ReactiveMongoRepository<Voto, String> {
	
	Flux<Voto> getByAssociadoAndSessaoVotacao(String idAssociado, String idSessaoVotacao);
	
	Flux<Voto> getByAssociado(String idAssociado);

	Flux<Voto> getBySessaoVotacao(String idSessaoVotacao);
	
}
