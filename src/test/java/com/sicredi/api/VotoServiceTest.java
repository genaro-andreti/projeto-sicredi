package com.sicredi.api;

import java.time.LocalDateTime;

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
		Associado associadoMock = new Associado();
		associadoMock.setId("14");
		associadoMock.setLogin("98999168034");

		Pauta pautaMock = new Pauta();
		pautaMock.setId("1");

		SessaoVotacao sessaoVotacaoMock = new SessaoVotacao();
		sessaoVotacaoMock.setId("1");
		sessaoVotacaoMock.setInicioSessaoVotacao(LocalDateTime.now());
		sessaoVotacaoMock.setFimSessaoVotacao(LocalDateTime.now().plusMinutes(2L));
		sessaoVotacaoMock.setPauta(pautaMock);

		Voto votoMock = new Voto();
		votoMock.setId("1");
		votoMock.setAssociado(associadoMock);
		votoMock.setSessaoVotacao(sessaoVotacaoMock);
		votoMock.setDecisaoVoto(VotoEnum.SIM);

		Mockito.when(associadoService.associadoCadastrado(votoMock.getAssociado().getId()).block())
				.thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.sessaoVotacaoCadastrado(sessaoVotacaoMock.getId()).block())
				.thenReturn(sessaoVotacaoMock);

		Mockito.when(votoService.votoAssociadoCadastradoParaPauta(votoMock.getAssociado().getId(),
				votoMock.getSessaoVotacao().getPauta().getId())).thenReturn(Boolean.FALSE);
		Mockito.when(votoService.cadastrar(votoMock).block()).thenReturn(votoMock);

		Voto voto = votoService.cadastrar(votoMock).block();

		Assertions.assertThat(votoMock.getId().equals(voto.getId()));
		Assertions.assertThat(votoMock.getAssociado().equals(voto.getAssociado()));
		Assertions.assertThat(votoMock.getSessaoVotacao().equals(voto.getSessaoVotacao()));
		Assertions.assertThat(votoMock.getDecisaoVoto().equals(voto.getDecisaoVoto()));
	}

}
