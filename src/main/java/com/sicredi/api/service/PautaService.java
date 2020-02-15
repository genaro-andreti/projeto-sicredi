package com.sicredi.api.service;

import com.sicredi.api.model.Pauta;

import reactor.core.publisher.Mono;

public interface PautaService {
	
	Mono<Pauta> cadastrar(Pauta pauta);
	
	Mono<Boolean> pautaCadastrada(String idPauta);

}
