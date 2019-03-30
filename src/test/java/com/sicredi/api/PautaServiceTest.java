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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PautaServiceTest {
	
	@Autowired
	private PautaService pautaService;
	
	@MockBean
	private PautaRepository pautaRepository;
	
    @SuppressWarnings("static-access")
	@Test
    public void quandoInserimosUmaPauta() {
    	
		Pauta pautaMock = new Pauta().builder().id(1l).descricao("Teste cadastro pauta").build();
    	
    	Mockito.when(pautaService.cadastrar(pautaMock)).thenReturn(pautaMock);

    	Pauta pauta = pautaService.cadastrar(pautaMock);
    	
    	Assertions.assertThat(pauta.getId()).isEqualTo(pautaMock.getId());
    	Assertions.assertThat(pauta.getDescricao()).isEqualTo(pautaMock.getDescricao());
     }
    
}
