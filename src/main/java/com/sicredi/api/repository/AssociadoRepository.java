package com.sicredi.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sicredi.api.model.Associado;

@Repository
public interface AssociadoRepository extends ReactiveMongoRepository<Associado, String>{
	
}
