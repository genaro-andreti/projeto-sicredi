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

import com.sicredi.api.model.Associado;
import com.sicredi.api.repository.AssociadoRepository;
import com.sicredi.api.service.AssociadoService;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociadoServiceTest {

	@Autowired
	private AssociadoService associadoService;
	
    @MockBean
    private AssociadoRepository repository;
	
	@Autowired
    ReactiveMongoOperations operations;
	
	@Test
	public void quandoInserimosUmAssociado() {

		Associado associadoMock = new Associado();
		associadoMock.setId("5e470ed5558efb2b98a876b9");
		associadoMock.setNome("Jim Morrison");
		associadoMock.setLogin("98999168066");
		associadoMock.setSenha("123456");
		
		Mockito.when(repository.save(associadoMock)).thenReturn(Mono.just(associadoMock));
		
		Mono<Associado> associado = associadoService.cadastrar(associadoMock);

		Assertions.assertThat(associado.block().getId()).isEqualTo(associadoMock.getId());
		Assertions.assertThat(associado.block().getNome()).isEqualTo(associadoMock.getNome());
		Assertions.assertThat(associado.block().getLogin()).isEqualTo(associadoMock.getLogin());
		Assertions.assertThat(associado.block().getSenha()).isEqualTo(associadoMock.getSenha());
	}

}
