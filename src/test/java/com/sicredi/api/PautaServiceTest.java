package com.sicredi.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
	
	@Test
	public void quandoInserimosUmaPauta() {

		Pauta pautaMock = new Pauta();
		pautaMock.setId("60f4539d6f45562807356a07");
		pautaMock.setDescricao("Pauta teste");
		
		Mockito.when(pautaService.cadastrar(pautaMock)).thenReturn(Mono.just(pautaMock));

		Mono<Pauta> pauta = pautaService.cadastrar(pautaMock);

		Assertions.assertThat(pauta.block().getId()).isEqualTo(pautaMock.getId());
		Assertions.assertThat(pauta.block().getDescricao()).isEqualTo(pautaMock.getDescricao());
	}

}
