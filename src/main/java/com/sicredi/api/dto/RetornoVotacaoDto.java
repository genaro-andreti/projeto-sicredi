package com.sicredi.api.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.sicredi.api.enums.VotoEnum;
import com.sicredi.api.model.Pauta;
import com.sicredi.api.model.Voto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornoVotacaoDto {

	private static final String PAUTA_REPROVADA = "PAUTA REPROVADA";

	private static final String PAUTA_APROVADA = "PAUTA APROVADA";

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private Long idPauta;
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
					.forEach(voto -> getVotosDto().add(RetornoVotoDto.builder()
							.idAssociado(voto.getAssociado().getId()).nomeAssociado(voto.getAssociado().getNome())
							.idSessaoVotacao(voto.getSessaoVotacao().getId())
							.inicioSessaoVotacao(voto.getSessaoVotacao().getInicioSessaoVotacao().format(FORMATTER))
							.fimSessaoVotacao(voto.getSessaoVotacao().getFimSessaoVotacao().format(FORMATTER))
							.decisao(voto.getDecisaoVoto().getValor()).build()));
		}
		if(!CollectionUtils.isEmpty(getVotosDto())) {
			getVotosDto().forEach(voto -> {
				if(VotoEnum.SIM.getValor().equals(voto.getDecisao())) {
					this.qtdVotosFavoraveis++;
				} else {
					this.qtdVotosContra++;
				}
			});
			setResultadoVotacao(this.qtdVotosFavoraveis > this.qtdVotosContra ? PAUTA_APROVADA : PAUTA_REPROVADA);
		}
	}

}
