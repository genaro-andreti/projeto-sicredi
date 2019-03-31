package com.sicredi.api.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociadoDto {

	@NotEmpty(message = "Campo nome deve ser preenchido.")
	@Length(min = 3, max = 50, message = "Campo nome deve ter entre 3 e 50 caractéres.")
	private String nome;

	@NotEmpty(message = "Campo login deve ser preenchido.")
	@Length(min = 3, max = 50, message = "Campo login deve ter entre 3 e 50 caractéres.")
	private String login;

	@NotEmpty(message = "Campo senha deve ser preenchido.")
	@Length(min = 6, max = 6, message = "Campo senha deve ter 6 caractéres.")
	private String senha;
}
