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
		//validaCpf(voto.getAssociado().getId());
		validaCadastrar(voto);
		return votoRepository.save(voto);
	}
	
	/*private void validaCpf(String idAssociado) {
		Mono<Associado> associado = associadoService.findById(idAssociado);
		
		if(!ObjectUtils.isEmpty(associado)) {
			MonoCpfResponse cpfResponse = validaCpfService.validaCpf(associado.block().getLogin());
			
			if(CpfEnum.STATUS_404.equals(cpfResponse.getStatus())) {
				throw new CpfNaoEncontradoException();
			}
			
			if (CpfEnum.UNABLE_TO_VOTE.equals(cpfResponse.getStatus())) {
				throw new CpfInvalidoParaVotoException();
			}
		} else {
			throw new AssociadoNaoCadastradoException();
		}
	}*/

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
		
		System.out.println(sessaoCarregada.block().toString());

		if (votoAssociadoCadastradoParaPauta(voto.getAssociado().getId(), sessaoCarregada.block().getPauta().getId())) {
			throw new VotoAssociadoCadastradoParaPautaException();
		}
	}
	
	@Override
	public RetornoVotacaoDto retornaVotacaoPorPauta(String idPauta) {
		if (!pautaService.pautaCadastrada(idPauta).block()) {
			throw new PautaNaoCadastradoException();
		}

		Flux<Voto> votos = votoRepository.getBySessaoVotacaoPautaId(idPauta);
		
		if (votos.collectList().block().isEmpty()) {
			throw new PautaNaoVotadaException();
		}
		return new RetornoVotacaoDto(votos.collectList().block());
	}

	@Override
	public Boolean votoAssociadoCadastradoParaPauta(String idAssociado, String idPauta) {
		
		Flux<Voto> retorno = votoRepository.getByAssociadoIdAndSessaoVotacaoPautaId(idAssociado, idPauta);
		return !retorno.collectList().block().isEmpty();
	}

}
