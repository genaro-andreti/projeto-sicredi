package com.sicredi.api;

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
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.model.Voto;
import com.sicredi.api.repository.VotoRepository;
import com.sicredi.api.service.VotoService;

import reactor.core.publisher.Mono;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VotoServiceTest {

	@MockBean
	private VotoRepository votoRepository;
	
	@Autowired
	private VotoService votoService;
	
	@Test
	public void quandoCadastraVoto() {
		Associado associadoMock = new Associado();
		associadoMock.setId("60f4559c6f45562807356a0a");

		SessaoVotacao sessaoVotacaoMock = new SessaoVotacao();
		sessaoVotacaoMock.setId("60f456fc6f45562807356a0c");

		Voto votoMock = new Voto();
		votoMock.setId("60f454496f45562807356a09");
		votoMock.setAssociado(associadoMock);
		votoMock.setSessaoVotacao(sessaoVotacaoMock);
		votoMock.setDecisaoVoto(VotoEnum.SIM);
		
		Mockito.when(votoRepository.save(votoMock)).thenReturn(Mono.just(votoMock));

		Voto voto = votoService.cadastrar(votoMock).block();

		Assertions.assertThat(votoMock.getId().equals(voto.getId()));
		Assertions.assertThat(votoMock.getAssociado().equals(voto.getAssociado()));
		Assertions.assertThat(votoMock.getSessaoVotacao().equals(voto.getSessaoVotacao()));
		Assertions.assertThat(votoMock.getDecisaoVoto().equals(voto.getDecisaoVoto()));
	}

}
