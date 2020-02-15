package com.sicredi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.api.exception.PautaNaoCadastradoException;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.repository.SessaoVotacaoRepository;

import reactor.core.publisher.Mono;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private PautaService pautaService;

	@Override
	public Mono<SessaoVotacao> cadastrar(SessaoVotacao sessaoVotacao) {
		if (!pautaService.pautaCadastrada(sessaoVotacao.getPauta().getId()).block()) {
			throw new PautaNaoCadastradoException();
		}
		return sessaoVotacaoRepository.save(sessaoVotacao);
	}

	@Override
	public Mono<SessaoVotacao> sessaoVotacaoCadastrado(String idSessaoVotacao) {
		return sessaoVotacaoRepository.findById(idSessaoVotacao);
	}

}
