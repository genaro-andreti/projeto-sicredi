package com.sicredi.api.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.sicredi.api.enums.VotoEnum;
import com.sicredi.api.model.Pauta;
import com.sicredi.api.model.Voto;

public class RetornoVotacaoDto {

	private static final String PAUTA_REPROVADA = "PAUTA REPROVADA";

	private static final String PAUTA_APROVADA = "PAUTA APROVADA";

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private String idPauta;
	private String descricaoPauta;
	private List<RetornoVotoDto> votosDto;
	private Integer qtdVotosFavoraveis = 0;
	private Integer qtdVotosContra = 0;
	private String resultadoVotacao;

	public RetornoVotacaoDto(List<Voto> votos) {
		if (!CollectionUtils.isEmpty(votos)) {
			Pauta pauta = votos.get(0).getSessaoVotacao().getPauta();
			setIdPauta(pauta.getId());
			setDescricaoPauta(pauta.getDescricao());

			this.votosDto = CollectionUtils.isEmpty(this.votosDto) ? new ArrayList<RetornoVotoDto>() : this.votosDto;

			votos.stream()
					.forEach(voto -> getVotosDto().add(new RetornoVotoDto(voto.getAssociado().getId(),
							voto.getAssociado().getNome(), voto.getSessaoVotacao().getId(),
							voto.getSessaoVotacao().getInicioSessaoVotacao().format(FORMATTER),
							voto.getSessaoVotacao().getFimSessaoVotacao().format(FORMATTER),
							voto.getDecisaoVoto().getValor())));

		}
		if (!CollectionUtils.isEmpty(getVotosDto())) {
			getVotosDto().forEach(voto -> {
				if (VotoEnum.SIM.getValor().equals(voto.getDecisao())) {
					this.qtdVotosFavoraveis++;
				} else {
					this.qtdVotosContra++;
				}
			});
			setResultadoVotacao(this.qtdVotosFavoraveis > this.qtdVotosContra ? PAUTA_APROVADA : PAUTA_REPROVADA);
		}
	}

	public String getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(String idPauta) {
		this.idPauta = idPauta;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	public void setDescricaoPauta(String descricaoPauta) {
		this.descricaoPauta = descricaoPauta;
	}

	public List<RetornoVotoDto> getVotosDto() {
		return votosDto;
	}

	public void setVotosDto(List<RetornoVotoDto> votosDto) {
		this.votosDto = votosDto;
	}

	public Integer getQtdVotosFavoraveis() {
		return qtdVotosFavoraveis;
	}

	public void setQtdVotosFavoraveis(Integer qtdVotosFavoraveis) {
		this.qtdVotosFavoraveis = qtdVotosFavoraveis;
	}

	public Integer getQtdVotosContra() {
		return qtdVotosContra;
	}

	public void setQtdVotosContra(Integer qtdVotosContra) {
		this.qtdVotosContra = qtdVotosContra;
	}

	public String getResultadoVotacao() {
		return resultadoVotacao;
	}

	public void setResultadoVotacao(String resultadoVotacao) {
		this.resultadoVotacao = resultadoVotacao;
	}

	public static String getPautaReprovada() {
		return PAUTA_REPROVADA;
	}

	public static String getPautaAprovada() {
		return PAUTA_APROVADA;
	}

	public static DateTimeFormatter getFormatter() {
		return FORMATTER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoPauta == null) ? 0 : descricaoPauta.hashCode());
		result = prime * result + ((idPauta == null) ? 0 : idPauta.hashCode());
		result = prime * result + ((qtdVotosContra == null) ? 0 : qtdVotosContra.hashCode());
		result = prime * result + ((qtdVotosFavoraveis == null) ? 0 : qtdVotosFavoraveis.hashCode());
		result = prime * result + ((resultadoVotacao == null) ? 0 : resultadoVotacao.hashCode());
		result = prime * result + ((votosDto == null) ? 0 : votosDto.hashCode());
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
		RetornoVotacaoDto other = (RetornoVotacaoDto) obj;
		if (descricaoPauta == null) {
			if (other.descricaoPauta != null)
				return false;
		} else if (!descricaoPauta.equals(other.descricaoPauta))
			return false;
		if (idPauta == null) {
			if (other.idPauta != null)
				return false;
		} else if (!idPauta.equals(other.idPauta))
			return false;
		if (qtdVotosContra == null) {
			if (other.qtdVotosContra != null)
				return false;
		} else if (!qtdVotosContra.equals(other.qtdVotosContra))
			return false;
		if (qtdVotosFavoraveis == null) {
			if (other.qtdVotosFavoraveis != null)
				return false;
		} else if (!qtdVotosFavoraveis.equals(other.qtdVotosFavoraveis))
			return false;
		if (resultadoVotacao == null) {
			if (other.resultadoVotacao != null)
				return false;
		} else if (!resultadoVotacao.equals(other.resultadoVotacao))
			return false;
		if (votosDto == null) {
			if (other.votosDto != null)
				return false;
		} else if (!votosDto.equals(other.votosDto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RetornoVotacaoDto [idPauta=" + idPauta + ", descricaoPauta=" + descricaoPauta + ", votosDto=" + votosDto
				+ ", qtdVotosFavoraveis=" + qtdVotosFavoraveis + ", qtdVotosContra=" + qtdVotosContra
				+ ", resultadoVotacao=" + resultadoVotacao + "]";
	}

}
