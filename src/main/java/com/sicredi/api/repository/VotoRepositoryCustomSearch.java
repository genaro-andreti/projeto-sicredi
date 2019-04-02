package com.sicredi.api.repository;

import java.util.List;

import com.sicredi.api.model.Voto;

public interface VotoRepositoryCustomSearch {
	
	Boolean votoAssociadoCadastradoParaPauta(Long idAssociado, Long idPauta);
	
	List<Voto> retornaVotacaoPorPauta(Long idPauta);

}
