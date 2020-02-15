package com.sicredi.api.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "sessaoVotacao")
public class SessaoVotacao {

	@Id
	private String id;

	private LocalDateTime inicioSessaoVotacao;

	private LocalDateTime fimSessaoVotacao;
	
	@DBRef
	private Pauta pauta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getInicioSessaoVotacao() {
		return inicioSessaoVotacao;
	}

	public void setInicioSessaoVotacao(LocalDateTime inicioSessaoVotacao) {
		this.inicioSessaoVotacao = inicioSessaoVotacao;
	}

	public LocalDateTime getFimSessaoVotacao() {
		return fimSessaoVotacao;
	}

	public void setFimSessaoVotacao(LocalDateTime fimSessaoVotacao) {
		this.fimSessaoVotacao = fimSessaoVotacao;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fimSessaoVotacao == null) ? 0 : fimSessaoVotacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inicioSessaoVotacao == null) ? 0 : inicioSessaoVotacao.hashCode());
		result = prime * result + ((pauta == null) ? 0 : pauta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessaoVotacao other = (SessaoVotacao) obj;
		if (fimSessaoVotacao == null) {
			if (other.fimSessaoVotacao != null)
				return false;
		} else if (!fimSessaoVotacao.equals(other.fimSessaoVotacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inicioSessaoVotacao == null) {
			if (other.inicioSessaoVotacao != null)
				return false;
		} else if (!inicioSessaoVotacao.equals(other.inicioSessaoVotacao))
			return false;
		if (pauta == null) {
			if (other.pauta != null)
				return false;
		} else if (!pauta.equals(other.pauta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SessaoVotacao [id=" + id + ", inicioSessaoVotacao=" + inicioSessaoVotacao + ", fimSessaoVotacao="
				+ fimSessaoVotacao + ", pauta=" + pauta + "]";
	}

	public Boolean sessaoFechada() {
		if(this.fimSessaoVotacao != null && this.fimSessaoVotacao != null) {
			LocalDateTime now = LocalDateTime.now();
			Boolean isInicioBeforeOrEqual = this.fimSessaoVotacao.isBefore(now) || this.fimSessaoVotacao.isEqual(now);
			Boolean isFimAfterOrEqual = this.fimSessaoVotacao.isAfter(now) || this.fimSessaoVotacao.isEqual(now);
			return isInicioBeforeOrEqual && isFimAfterOrEqual;
		}
		return Boolean.FALSE;
	}

}
