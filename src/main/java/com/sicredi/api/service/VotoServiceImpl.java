package com.sicredi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sicredi.api.dto.RetornoVotacaoDto;
import com.sicredi.api.exception.AssociadoNaoCadastradoException;
import com.sicredi.api.exception.PautaNaoCadastradoException;
import com.sicredi.api.exception.PautaNaoVotadaException;
import com.sicredi.api.exception.SessaoVotacaoFechadaException;
import com.sicredi.api.exception.SessaoVotacaoNaoCadastradoException;
import com.sicredi.api.exception.VotoAssociadoCadastradoParaPautaException;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.model.Voto;
import com.sicredi.api.repository.VotoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private AssociadoService associadoService;

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@Autowired
	private PautaService pautaService;
	
	@Override
	public Mono<Voto> cadastrar(Voto voto) {
		validaCadastrar(voto);
		return votoRepository.save(voto);
	}
	
	private void validaCadastrar(Voto voto) {
		if (!associadoService.associadoCadastrado(voto.getAssociado().getId()).block()) {
			throw new AssociadoNaoCadastradoException();
		}

		Mono<SessaoVotacao> sessaoCarregada = sessaoVotacaoService
				.sessaoVotacaoCadastrado(voto.getSessaoVotacao().getId());

		if (ObjectUtils.isEmpty(sessaoCarregada.block())) {
			throw new SessaoVotacaoNaoCadastradoException();
		}

		if (sessaoCarregada.block().sessaoFechada()) {
			throw new SessaoVotacaoFechadaException();
		}
		
		if (votoAssociadoCadastradoParaPauta(voto.getAssociado().getId(), sessaoCarregada.block().getId())) {
			throw new VotoAssociadoCadastradoParaPautaException();
		}
	}
	
	@Override
	public RetornoVotacaoDto retornaVotacaoPorPauta(String idPauta) {
		if (!pautaService.pautaCadastrada(idPauta).block()) {
			throw new PautaNaoCadastradoException();
		}

		Mono<SessaoVotacao> sessaoVotacao = sessaoVotacaoService.getByPauta(idPauta);
		
		Flux<Voto> votos = votoRepository.getBySessaoVotacao(sessaoVotacao.block().getId());
		
		if (votos.collectList().block().isEmpty()) {
			throw new PautaNaoVotadaException();
		}
		
		return new RetornoVotacaoDto(votos.collectList().block());
	}

	@Override
	public Boolean votoAssociadoCadastradoParaPauta(String idAssociado, String idSessaoVotacao) {
		return !votoRepository.getByAssociadoAndSessaoVotacao(idAssociado, idSessaoVotacao).collectList().block().isEmpty();
	}

}
