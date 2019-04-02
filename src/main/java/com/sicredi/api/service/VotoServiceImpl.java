package com.sicredi.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	public Voto cadastrar(Voto voto) {
		validaCadastrar(voto);
		return votoRepository.save(voto);
	}

	private void validaCadastrar(Voto voto) {
		if (!associadoService.associadoCadastrado(voto.getAssociado().getId())) {
			throw new AssociadoNaoCadastradoException();
		}

		Optional<SessaoVotacao> sessaoCarregada = sessaoVotacaoService
				.sessaoVotacaoCadastrado(voto.getSessaoVotacao().getId());

		if (!sessaoCarregada.isPresent()) {
			throw new SessaoVotacaoNaoCadastradoException();
		}

		if (sessaoCarregada.get().sessaoFechada()) {
			throw new SessaoVotacaoFechadaException();
		}

		if (votoAssociadoCadastradoParaPauta(voto.getAssociado().getId(), sessaoCarregada.get().getPauta().getId())) {
			throw new VotoAssociadoCadastradoParaPautaException();
		}
	}

	@Override
	public RetornoVotacaoDto retornaVotacaoPorPauta(Long idPauta) {
		if (!pautaService.pautaCadastrada(idPauta)) {
			throw new PautaNaoCadastradoException();
		}

		List<Voto> votos = votoRepository.retornaVotacaoPorPauta(idPauta);

		if (CollectionUtils.isEmpty(votos)) {
			throw new PautaNaoVotadaException();
		}
		return new RetornoVotacaoDto(votos);
	}

	@Override
	public Boolean votoAssociadoCadastradoParaPauta(Long idAssociado, Long idPauta) {
		return votoRepository.votoAssociadoCadastradoParaPauta(idAssociado, idPauta);
	}

}
