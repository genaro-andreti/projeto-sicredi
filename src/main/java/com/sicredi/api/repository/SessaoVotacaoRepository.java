package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sicredi.api.model.SessaoVotacao;

public interface SessaoVotacaoRepository extends ReactiveMongoRepository<SessaoVotacao, String> {

}
