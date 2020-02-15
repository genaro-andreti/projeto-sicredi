package com.sicredi.api.service;

import com.sicredi.api.model.Associado;

import reactor.core.publisher.Mono;

public interface AssociadoService {
	
	Mono<Associado> cadastrar(Associado ssociado);
	
	Mono<Boolean> associadoCadastrado(String idAssociado);
	
	Mono<Associado> findById(String idAssociado);

}
