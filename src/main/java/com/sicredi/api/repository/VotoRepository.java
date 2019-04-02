package com.sicredi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicredi.api.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>, VotoRepositoryCustomSearch {

}
