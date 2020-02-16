package com.sicredi.api.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		AssociadoDto other = (AssociadoDto) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssociadoDto [nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}
	
}
