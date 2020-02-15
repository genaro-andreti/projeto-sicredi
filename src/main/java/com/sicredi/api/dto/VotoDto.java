package com.sicredi.api.dto;

import javax.validation.constraints.NotNull;

import com.sicredi.api.enums.VotoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDto {

	@NotNull(message = "Campo Associado deve ser preenchido.")
	private String idAssociado;

	@NotNull(message = "Campo Sessão Votação deve ser preenchido.")
	private String idSessaoVotacao;

	@NotNull(message = "Campo valor do voto deve ser preenchido.")
	private VotoEnum valorVoto;

}
