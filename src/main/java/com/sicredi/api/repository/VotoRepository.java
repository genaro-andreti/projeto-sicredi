package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sicredi.api.model.Voto;

import reactor.core.publisher.Flux;

public interface VotoRepository extends ReactiveMongoRepository<Voto, String>, VotoRepositoryCustomSearch {
	
	Flux<Voto> getBySessaoVotacaoPautaId(String idPauta);
	
	Flux<Voto> getByAssociadoIdAndSessaoVotacaoPautaId(String idAssociado, String idPauta);
	
	Flux<Voto> getByAssociadoId(String idAssociado);

}
