package com.sicredi.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.sicredi.api.model.Voto;

import reactor.core.publisher.Flux;

@Repository
public class VotoRepositoryImpl implements VotoRepositoryCustomSearch {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Override
	public Boolean votoAssociadoCadastradoParaPauta(String idAssociado, String idPauta) {
		Query query = new Query();
		query.addCriteria(Criteria.where("sessaoVotacao.pauta.id").is(idPauta).and("associado.id").is(idAssociado));

		Voto result = reactiveMongoTemplate.findOne(query, Voto.class).block();

		return !ObjectUtils.isEmpty(result);
	}

	@Override
	public Flux<Voto> retornaVotacaoPorPauta(String idPauta) {
		Query query = new Query();
		query.addCriteria(Criteria.where("sessaoVotacao.pauta.id").is(idPauta));
		
		Flux<Voto> result = reactiveMongoTemplate.find(query, Voto.class);

		return result;
	}

}
