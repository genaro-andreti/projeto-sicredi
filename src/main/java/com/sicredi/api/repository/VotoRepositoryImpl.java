package com.sicredi.api.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.sicredi.api.model.Voto;

@Repository
public class VotoRepositoryImpl implements VotoRepositoryCustomSearch {

	@PersistenceContext
	private EntityManager em;

	public Boolean votoAssociadoCadastradoParaPauta(Long idPauta, Long idAssociado) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Voto> cq = cb.createQuery(Voto.class);

		Root<Voto> book = cq.from(Voto.class);

		Predicate pautaPredicate = cb.equal(book.get("sessaoVotacao").get("pauta").get("id"), idPauta);
		Predicate associadoPredicate = cb.equal(book.get("associado").get("id"), idAssociado);

		cq.where(pautaPredicate, associadoPredicate);

		return !CollectionUtils.isEmpty(em.createQuery(cq).getResultList());
	}

	public List<Voto> retornaVotacaoPorPauta(Long idPauta) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Voto> cq = cb.createQuery(Voto.class);

		Root<Voto> book = cq.from(Voto.class);
		Predicate predicate = null;

		if (Objects.nonNull(idPauta)) {
			predicate = cb.equal(book.get("sessaoVotacao").get("pauta").get("id"), idPauta);
		}

		cq.where(predicate);

		return em.createQuery(cq).getResultList();
	}

}
