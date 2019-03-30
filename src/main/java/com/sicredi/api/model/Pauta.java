package com.sicredi.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pauta")
public class Pauta implements Serializable {
	private static final long serialVersionUID = 7900240469798549445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@Column(name = "id_pauta", nullable = false)
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "descricao", nullable = false)
	private String descricao;
		
}
