package com.sicredi.api.dto;

import javax.validation.constraints.NotNull;

import com.sicredi.api.enums.VotoEnum;

public class VotoDto {

	@NotNull(message = "Campo Associado deve ser preenchido.")
	private String idAssociado;

	@NotNull(message = "Campo Sessão Votação deve ser preenchido.")
	private String idSessaoVotacao;

	@NotNull(message = "Campo valor do voto deve ser preenchido.")
	private VotoEnum valorVoto;

	public String getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(String idAssociado) {
		this.idAssociado = idAssociado;
	}

	public String getIdSessaoVotacao() {
		return idSessaoVotacao;
	}

	public void setIdSessaoVotacao(String idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}

	public VotoEnum getValorVoto() {
		return valorVoto;
	}

	public void setValorVoto(VotoEnum valorVoto) {
		this.valorVoto = valorVoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAssociado == null) ? 0 : idAssociado.hashCode());
		result = prime * result + ((idSessaoVotacao == null) ? 0 : idSessaoVotacao.hashCode());
		result = prime * result + ((valorVoto == null) ? 0 : valorVoto.hashCode());
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
		VotoDto other = (VotoDto) obj;
		if (idAssociado == null) {
			if (other.idAssociado != null)
				return false;
		} else if (!idAssociado.equals(other.idAssociado))
			return false;
		if (idSessaoVotacao == null) {
			if (other.idSessaoVotacao != null)
				return false;
		} else if (!idSessaoVotacao.equals(other.idSessaoVotacao))
			return false;
		if (valorVoto != other.valorVoto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VotoDto [idAssociado=" + idAssociado + ", idSessaoVotacao=" + idSessaoVotacao + ", valorVoto="
				+ valorVoto + "]";
	}
	
}
