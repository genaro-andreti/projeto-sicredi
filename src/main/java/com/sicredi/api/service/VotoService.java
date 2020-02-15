package com.sicredi.api.service;

import com.sicredi.api.dto.RetornoVotacaoDto;
import com.sicredi.api.model.Voto;

import reactor.core.publisher.Mono;

public interface VotoService {

	Mono<Voto> cadastrar(Voto voto);
	
	Boolean votoAssociadoCadastradoParaPauta(String idAssociado, String idPauta);
	
	RetornoVotacaoDto retornaVotacaoPorPauta(String idPauta);

}
