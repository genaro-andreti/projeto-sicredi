package com.sicredi.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.sicredi.api.model.Pauta;
import com.sicredi.api.repository.PautaRepository;
import com.sicredi.api.service.PautaService;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PautaServiceTest {

	@Autowired
	private PautaService pautaService;

	@MockBean
	private PautaRepository pautaRepository;
	
	@Autowired
    ReactiveMongoOperations operations;

	@Test
	public void quandoInserimosUmaPauta() {

		Pauta pautaMock = new Pauta();
		pautaMock.setId("5e470eee558efb2b98a876ba");
		pautaMock.setDescricao("Pauta de teste 2");
		
		Mockito.when(pautaRepository.save(pautaMock)).thenReturn(Mono.just(pautaMock));

		Mono<Pauta> pauta = pautaService.cadastrar(pautaMock);

		Assertions.assertThat(pauta.block().getId()).isEqualTo(pautaMock.getId());
		Assertions.assertThat(pauta.block().getDescricao()).isEqualTo(pautaMock.getDescricao());
	}

}
