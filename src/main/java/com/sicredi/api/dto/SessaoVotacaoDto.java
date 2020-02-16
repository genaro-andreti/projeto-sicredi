package com.sicredi.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

public class SessaoVotacaoDto {

	private static final Long TEMPO_SESSAO_VOTACAO_DEFAULT = 1L;

	private Integer tempoSessao;

	@NotNull(message = "Campo Pauta deve ser preenchido.")
	private String idPauta;

	public LocalDateTime dataFim(LocalDateTime dataInicio) {
		return Objects.isNull(getTempoSessao()) ? dataInicio.plusMinutes(TEMPO_SESSAO_VOTACAO_DEFAULT)
				: dataInicio.plusMinutes(getTempoSessao());
	}

	public Integer getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(Integer tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	public String getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(String idPauta) {
		this.idPauta = idPauta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPauta == null) ? 0 : idPauta.hashCode());
		result = prime * result + ((tempoSessao == null) ? 0 : tempoSessao.hashCode());
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
		SessaoVotacaoDto other = (SessaoVotacaoDto) obj;
		if (idPauta == null) {
			if (other.idPauta != null)
				return false;
		} else if (!idPauta.equals(other.idPauta))
			return false;
		if (tempoSessao == null) {
			if (other.tempoSessao != null)
				return false;
		} else if (!tempoSessao.equals(other.tempoSessao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SessaoVotacaoDto [tempoSessao=" + tempoSessao + ", idPauta=" + idPauta + "]";
	}
	
}
