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

import reactor.core.publisher.Mono;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SessaoVotacaoServiceTest {

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@MockBean
	private SessaoVotacaoRepository ressaoVotacaoRepository;

	@Test
	public void quandoCadastraSessaoVotacao() {
		SessaoVotacao sessaoVotacaoMock = new SessaoVotacao();
		sessaoVotacaoMock.setId("1");
		sessaoVotacaoMock.setInicioSessaoVotacao(LocalDateTime.now());
		sessaoVotacaoMock.setFimSessaoVotacao(LocalDateTime.now().plusMinutes(2L));
		
		Pauta pautaMock = new Pauta();
		pautaMock.setId("1");
		
		sessaoVotacaoMock.setPauta(pautaMock);

		Mockito.when(sessaoVotacaoService.cadastrar(sessaoVotacaoMock).block()).thenReturn(sessaoVotacaoMock);

		Mono<SessaoVotacao> sessaoVotacao = sessaoVotacaoService.cadastrar(sessaoVotacaoMock);

		Assertions.assertThat(sessaoVotacaoMock.getId().equals(sessaoVotacao.block().getId()));
		Assertions.assertThat(sessaoVotacaoMock.getPauta().equals(sessaoVotacao.block().getPauta()));
		Assertions
				.assertThat(sessaoVotacaoMock.getInicioSessaoVotacao().equals(sessaoVotacao.block().getInicioSessaoVotacao()));
		Assertions.assertThat(sessaoVotacaoMock.getFimSessaoVotacao().equals(sessaoVotacao.block().getFimSessaoVotacao()));
	}

}
