package com.sicredi.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
	
	@Test
	public void quandoInserimosUmAssociado() {

		Associado associadoMock = new Associado();
		associadoMock.setId("60f453556f45562807356a06");
		associadoMock.setNome("Genaro");
		associadoMock.setCpf("98999168034");
		associadoMock.setLogin("gena");
		associadoMock.setSenha("123456");
		
		Mockito.when(associadoService.cadastrar(associadoMock)).thenReturn(Mono.just(associadoMock));
		
		Mono<Associado> associado = associadoService.cadastrar(associadoMock);

		Assertions.assertThat(associado.block().getId()).isEqualTo(associadoMock.getId());
		Assertions.assertThat(associado.block().getNome()).isEqualTo(associadoMock.getNome());
		Assertions.assertThat(associado.block().getCpf()).isEqualTo(associadoMock.getCpf());
		Assertions.assertThat(associado.block().getLogin()).isEqualTo(associadoMock.getLogin());
		Assertions.assertThat(associado.block().getSenha()).isEqualTo(associadoMock.getSenha());
	}

}
