package com.sicredi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RetornoVotoDto {

	private String idAssociado;
	private String nomeAssociado;
	private String idSessaoVotacao;
	private String inicioSessaoVotacao;
	private String fimSessaoVotacao;
	private String decisao;

}
