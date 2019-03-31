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

import com.sicredi.api.model.Pauta;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.repository.SessaoVotacaoRepository;
import com.sicredi.api.service.SessaoVotacaoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SessaoVotacaoServiceTest {

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@MockBean
	private SessaoVotacaoRepository ressaoVotacaoRepository;

	@SuppressWarnings("static-access")
	@Test
	public void quandoCadastraSessaoVotacao() {
		SessaoVotacao sessaoVotacaoMock = new SessaoVotacao().builder().id(1L)
				.pauta(new Pauta().builder().id(1L).build()).inicioSessaoVotacao(LocalDateTime.now())
				.fimSessaoVotacao(LocalDateTime.now().plusMinutes(2L)).build();

		Mockito.when(sessaoVotacaoService.cadastrar(sessaoVotacaoMock)).thenReturn(sessaoVotacaoMock);

		SessaoVotacao sessaoVotacao = sessaoVotacaoService.cadastrar(sessaoVotacaoMock);

		Assertions.assertThat(sessaoVotacaoMock.getId().equals(sessaoVotacao.getId()));
		Assertions.assertThat(sessaoVotacaoMock.getPauta().equals(sessaoVotacao.getPauta()));
		Assertions
				.assertThat(sessaoVotacaoMock.getInicioSessaoVotacao().equals(sessaoVotacao.getInicioSessaoVotacao()));
		Assertions.assertThat(sessaoVotacaoMock.getFimSessaoVotacao().equals(sessaoVotacao.getFimSessaoVotacao()));
	}

}
