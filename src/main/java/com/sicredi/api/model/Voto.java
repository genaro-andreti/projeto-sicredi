package com.sicredi.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sicredi.api.enums.VotoEnum;

@Document(value = "voto")
public class Voto {
	
	@Id
	private String id;
	
	@DBRef(lazy = true)
	private Associado associado;
	
	@DBRef(lazy = true)
	private SessaoVotacao sessaoVotacao;
	
	private VotoEnum decisaoVoto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public SessaoVotacao getSessaoVotacao() {
		return sessaoVotacao;
	}

	public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
		this.sessaoVotacao = sessaoVotacao;
	}

	public VotoEnum getDecisaoVoto() {
		return decisaoVoto;
	}

	public void setDecisaoVoto(VotoEnum decisaoVoto) {
		this.decisaoVoto = decisaoVoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associado == null) ? 0 : associado.hashCode());
		result = prime * result + ((decisaoVoto == null) ? 0 : decisaoVoto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sessaoVotacao == null) ? 0 : sessaoVotacao.hashCode());
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
		Voto other = (Voto) obj;
		if (associado == null) {
			if (other.associado != null)
				return false;
		} else if (!associado.equals(other.associado))
			return false;
		if (decisaoVoto != other.decisaoVoto)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sessaoVotacao == null) {
			if (other.sessaoVotacao != null)
				return false;
		} else if (!sessaoVotacao.equals(other.sessaoVotacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", associado=" + associado + ", sessaoVotacao=" + sessaoVotacao + ", decisaoVoto="
				+ decisaoVoto + "]";
	}
	
}
