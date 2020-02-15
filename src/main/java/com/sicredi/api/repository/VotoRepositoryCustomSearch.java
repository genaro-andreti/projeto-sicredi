package com.sicredi.api.repository;

import com.sicredi.api.model.Voto;

import reactor.core.publisher.Flux;

public interface VotoRepositoryCustomSearch {
	
	Boolean votoAssociadoCadastradoParaPauta(String idAssociado, String idPauta);
	
	Flux<Voto> retornaVotacaoPorPauta(String idPauta);

}
