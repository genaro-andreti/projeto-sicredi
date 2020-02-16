package com.sicredi.api.dto;

public class RetornoVotoDto {

	private String idAssociado;
	private String nomeAssociado;
	private String idSessaoVotacao;
	private String inicioSessaoVotacao;
	private String fimSessaoVotacao;
	private String decisao;
	
	public RetornoVotoDto(String idAssociado, String nomeAssociado, String idSessaoVotacao, String inicioSessaoVotacao,
			String fimSessaoVotacao, String decisao) {
		this.idAssociado = idAssociado;
		this.nomeAssociado = nomeAssociado;
		this.idSessaoVotacao = idSessaoVotacao;
		this.inicioSessaoVotacao = inicioSessaoVotacao;
		this.fimSessaoVotacao = fimSessaoVotacao;
		this.decisao = decisao;
	}
	
	public String getIdAssociado() {
		return idAssociado;
	}
	public void setIdAssociado(String idAssociado) {
		this.idAssociado = idAssociado;
	}
	public String getNomeAssociado() {
		return nomeAssociado;
	}
	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}
	public String getIdSessaoVotacao() {
		return idSessaoVotacao;
	}
	public void setIdSessaoVotacao(String idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}
	public String getInicioSessaoVotacao() {
		return inicioSessaoVotacao;
	}
	public void setInicioSessaoVotacao(String inicioSessaoVotacao) {
		this.inicioSessaoVotacao = inicioSessaoVotacao;
	}
	public String getFimSessaoVotacao() {
		return fimSessaoVotacao;
	}
	public void setFimSessaoVotacao(String fimSessaoVotacao) {
		this.fimSessaoVotacao = fimSessaoVotacao;
	}
	public String getDecisao() {
		return decisao;
	}
	public void setDecisao(String decisao) {
		this.decisao = decisao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decisao == null) ? 0 : decisao.hashCode());
		result = prime * result + ((fimSessaoVotacao == null) ? 0 : fimSessaoVotacao.hashCode());
		result = prime * result + ((idAssociado == null) ? 0 : idAssociado.hashCode());
		result = prime * result + ((idSessaoVotacao == null) ? 0 : idSessaoVotacao.hashCode());
		result = prime * result + ((inicioSessaoVotacao == null) ? 0 : inicioSessaoVotacao.hashCode());
		result = prime * result + ((nomeAssociado == null) ? 0 : nomeAssociado.hashCode());
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
		RetornoVotoDto other = (RetornoVotoDto) obj;
		if (decisao == null) {
			if (other.decisao != null)
				return false;
		} else if (!decisao.equals(other.decisao))
			return false;
		if (fimSessaoVotacao == null) {
			if (other.fimSessaoVotacao != null)
				return false;
		} else if (!fimSessaoVotacao.equals(other.fimSessaoVotacao))
			return false;
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
		if (inicioSessaoVotacao == null) {
			if (other.inicioSessaoVotacao != null)
				return false;
		} else if (!inicioSessaoVotacao.equals(other.inicioSessaoVotacao))
			return false;
		if (nomeAssociado == null) {
			if (other.nomeAssociado != null)
				return false;
		} else if (!nomeAssociado.equals(other.nomeAssociado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RetornoVotoDto [idAssociado=" + idAssociado + ", nomeAssociado=" + nomeAssociado + ", idSessaoVotacao="
				+ idSessaoVotacao + ", inicioSessaoVotacao=" + inicioSessaoVotacao + ", fimSessaoVotacao="
				+ fimSessaoVotacao + ", decisao=" + decisao + "]";
	}
	
}
