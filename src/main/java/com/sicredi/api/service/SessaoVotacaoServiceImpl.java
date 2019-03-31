package com.sicredi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.repository.SessaoVotacaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@Override
	public SessaoVotacao cadastrar(SessaoVotacao sessaoVotacao) {
		return sessaoVotacaoRepository.save(sessaoVotacao);
	}

}
