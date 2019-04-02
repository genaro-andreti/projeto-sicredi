package com.sicredi.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicredi.api.exception.PautaNaoCadastradoException;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.repository.SessaoVotacaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {
	
	@Autowired
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@Autowired
	private PautaService pautaService;

	@Override
	public SessaoVotacao cadastrar(SessaoVotacao sessaoVotacao) {
		if (!pautaService.pautaCadastrada(sessaoVotacao.getPauta().getId())) {
			throw new PautaNaoCadastradoException();
		}
		return sessaoVotacaoRepository.save(sessaoVotacao);
	}

	@Override
	public Optional<SessaoVotacao> sessaoVotacaoCadastrado(Long idSessaoVotacao) {
		return sessaoVotacaoRepository.findById(idSessaoVotacao);
	}

}
