package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sicredi.api.model.Pauta;

@Repository
public interface PautaRepository extends ReactiveMongoRepository<Pauta, String>{

}
