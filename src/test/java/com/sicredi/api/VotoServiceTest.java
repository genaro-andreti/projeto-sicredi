package com.sicredi.api;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
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
import com.sicredi.api.service.VotoService;

import reactor.core.publisher.Mono;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VotoServiceTest {

	@MockBean
	private AssociadoRepository associadoRepository;

	@MockBean
	private PautaRepository pautaRepository;

	@MockBean
	private SessaoVotacaoRepository sessaoVotacaoRepository;

	@MockBean
	private VotoRepository votoRepository;
	
	@Autowired
	private VotoService votoService;
	
	@Autowired
    ReactiveMongoOperations operations;

	@Test
	public void quandoCadastraVoto() {
		Associado associadoMock = new Associado();
		associadoMock.setId("5e470ed5558efb2b98a876b9");

		Pauta pautaMock = new Pauta();
		pautaMock.setId("5e470eee558efb2b98a876ba");

		SessaoVotacao sessaoVotacaoMock = new SessaoVotacao();
		sessaoVotacaoMock.setId("5e470efe558efb2b98a876bb");
		sessaoVotacaoMock.setInicioSessaoVotacao(LocalDateTime.now());
		sessaoVotacaoMock.setFimSessaoVotacao(LocalDateTime.now().plusMinutes(2L));
		sessaoVotacaoMock.setPauta(pautaMock);

		Voto votoMock = new Voto();
		votoMock.setId("5e470f2d558efb2b98a876bc");
		votoMock.setAssociado(associadoMock);
		votoMock.setSessaoVotacao(sessaoVotacaoMock);
		votoMock.setDecisaoVoto(VotoEnum.SIM);

		/*Mockito.when(
				associadoRepository.existsById(votoMock.getAssociado().getId())
				.thenReturn(Mono.just(false)));
		Mockito.when(sessaoVotacaoRepository.findById(sessaoVotacaoMock.getId()))
				.thenReturn(Mono.just(sessaoVotacaoMock));

		Mockito.when(votoRepository.getByAssociadoAndSessaoVotacao(associadoMock.getId(), sessaoVotacaoMock.getId())
				.collectList().block().isEmpty()).thenReturn(Boolean.TRUE);
				*/

		Mockito.when(votoRepository.save(votoMock)).thenReturn(Mono.just(votoMock));

		Voto voto = votoService.cadastrar(votoMock).block();

		Assertions.assertThat(votoMock.getId().equals(voto.getId()));
		Assertions.assertThat(votoMock.getAssociado().equals(voto.getAssociado()));
		Assertions.assertThat(votoMock.getSessaoVotacao().equals(voto.getSessaoVotacao()));
		Assertions.assertThat(votoMock.getDecisaoVoto().equals(voto.getDecisaoVoto()));
	}

}
