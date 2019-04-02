package com.sicredi.api.service;

import com.sicredi.api.dto.RetornoVotacaoDto;
import com.sicredi.api.model.Voto;

public interface VotoService {

	Voto cadastrar(Voto voto);
	
	Boolean votoAssociadoCadastradoParaPauta(Long idAssociado, Long idPauta);
	
	RetornoVotacaoDto retornaVotacaoPorPauta(Long idPauta);

}
