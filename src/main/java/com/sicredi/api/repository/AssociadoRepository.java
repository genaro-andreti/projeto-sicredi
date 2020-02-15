package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sicredi.api.model.Associado;

public interface AssociadoRepository extends ReactiveMongoRepository<Associado, String>{
	
}
