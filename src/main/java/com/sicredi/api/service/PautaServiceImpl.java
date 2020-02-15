package com.sicredi.api.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.api.model.Pauta;
import com.sicredi.api.repository.PautaRepository;

import reactor.core.publisher.Mono;

@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;

	@Override
	public Mono<Pauta> cadastrar(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	@Override
	public Mono<Boolean> pautaCadastrada(String idPauta) {
		return pautaRepository.existsById(idPauta);
	}

}
