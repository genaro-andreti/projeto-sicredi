package com.sicredi.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessaoVotacaoDto {

	private static final Long TEMPO_SESSAO_VOTACAO_DEFAULT = 1L;

	private Integer tempoSessao;

	@NotNull(message = "Campo Pauta deve ser preenchido.")
	private Long idPauta;

	public LocalDateTime dataFim(LocalDateTime dataInicio) {
		return Objects.isNull(getTempoSessao()) ? dataInicio.plusMinutes(TEMPO_SESSAO_VOTACAO_DEFAULT)
				: dataInicio.plusMinutes(getTempoSessao());
	}
}
