package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sicredi.api.model.Pauta;

public interface PautaRepository extends ReactiveMongoRepository<Pauta, String>{

}
