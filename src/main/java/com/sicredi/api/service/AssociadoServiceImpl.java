package com.sicredi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.api.model.Associado;
import com.sicredi.api.repository.AssociadoRepository;

import reactor.core.publisher.Mono;

@Service
public class AssociadoServiceImpl implements AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;

	@Override
	public Mono<Associado> cadastrar(Associado associado) {
		return associadoRepository.save(associado);
	}

	@Override
	public Mono<Boolean> associadoCadastrado(String idAssociado) {
		return associadoRepository.existsById(idAssociado);
	}
	
	@Override
	public Mono<Associado> findById(String idAssociado) {
		return associadoRepository.findById(idAssociado);
	}

}
