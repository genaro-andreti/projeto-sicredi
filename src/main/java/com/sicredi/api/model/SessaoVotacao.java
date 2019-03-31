package com.sicredi.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "sessao_votacao")
public class SessaoVotacao implements Serializable {
	private static final long serialVersionUID = 2944745228938849587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sessao_votacao", nullable = false)
	private Long id;

	@Column(name = "inicio_sessao_votacao", nullable = true)
	private LocalDateTime inicioSessaoVotacao;

	@Column(name = "fim_sessao_votacao", nullable = true)
	private LocalDateTime fimSessaoVotacao;

	@ManyToOne
	@JoinColumn(name = "id_pauta", referencedColumnName = "id_pauta", nullable = false)
	private Pauta pauta;

}
