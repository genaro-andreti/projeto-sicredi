package com.sicredi.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sicredi.api.enums.VotoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Voto implements Serializable {
	private static final long serialVersionUID = 3053826529040200492L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_voto", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_associado", referencedColumnName = "id_associado")
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name = "id_sessao_votacao", referencedColumnName = "id_sessao_votacao")
	private SessaoVotacao sessaoVotacao;
	
	@Column(name = "valor", nullable = false)
	@Enumerated(EnumType.STRING)
	private VotoEnum decisaoVoto;

}
