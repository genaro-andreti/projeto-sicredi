package com.sicredi.api.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaDto {

	@NotEmpty(message = "Campo descrição deve ser preenchido.")
	@Length(min = 5, max = 200, message = "Campo descrição deve ter entre 5 e 200 caractéres.")
	private String descricao;

}
