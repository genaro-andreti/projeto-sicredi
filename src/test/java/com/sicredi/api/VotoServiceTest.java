package com.sicredi.api;

import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sicredi.api.enums.VotoEnum;
import com.sicredi.api.model.Associado;
import com.sicredi.api.model.Pauta;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.model.Voto;
import com.sicredi.api.repository.AssociadoRepository;
import com.sicredi.api.repository.PautaRepository;
import com.sicredi.api.repository.SessaoVotacaoRepository;
import com.sicredi.api.repository.VotoRepository;
import com.sicredi.api.service.AssociadoService;
import com.sicredi.api.service.SessaoVotacaoService;
import com.sicredi.api.service.VotoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VotoServiceTest {

	@Autowired
	private VotoService votoService;

	@Autowired
	private AssociadoService associadoService;

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@MockBean
	private PautaRepository pautaRepository;

	@MockBean
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@MockBean
	private AssociadoRepository associadoRepository;

	@MockBean
	private VotoRepository votoRepository;

	@Test
	public void quandoCadastraVoto() {
		Associado associadoMock = Associado.builder().id(1L).build();
		SessaoVotacao sessaoVotacaoMock = SessaoVotacao.builder().id(1L)
				.pauta(Pauta.builder().id(1L).build()).inicioSessaoVotacao(LocalDateTime.now())
				.fimSessaoVotacao(LocalDateTime.now().plusMinutes(2)).build();
		new Voto();
		Voto votoMock = Voto.builder().id(1L).decisaoVoto(VotoEnum.SIM).associado(associadoMock)
				.sessaoVotacao(sessaoVotacaoMock).build();

		Mockito.when(associadoService.associadoCadastrado(votoMock.getAssociado().getId())).thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.sessaoVotacaoCadastrado(sessaoVotacaoMock.getId()))
				.thenReturn(Optional.of(sessaoVotacaoMock));
		Mockito.when(votoService.votoAssociadoCadastradoParaPauta(votoMock.getAssociado().getId(),
				votoMock.getSessaoVotacao().getPauta().getId())).thenReturn(Boolean.FALSE);
		Mockito.when(votoService.cadastrar(votoMock)).thenReturn(votoMock);

		Voto voto = votoService.cadastrar(votoMock);

		Assertions.assertThat(votoMock.getId().equals(voto.getId()));
		Assertions.assertThat(votoMock.getAssociado().equals(voto.getAssociado()));
		Assertions.assertThat(votoMock.getSessaoVotacao().equals(voto.getSessaoVotacao()));
		Assertions.assertThat(votoMock.getDecisaoVoto().equals(voto.getDecisaoVoto()));
	}

}
