package com.sicredi.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.api.dto.RetornoVotacaoDto;
import com.sicredi.api.dto.VotoDto;
import com.sicredi.api.model.Associado;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.model.Voto;
import com.sicredi.api.response.Response;
import com.sicredi.api.service.VotoService;

@RestController
@RequestMapping("/sicredi/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;

	@ResponseBody
	@PostMapping(path = "/cadastrar", produces = "application/json")
	public ResponseEntity<Response<Voto>> cadastrar(@Valid @RequestBody VotoDto votoDto, BindingResult result) {
		Response<Voto> response = new Response<Voto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Voto voto = votoService.cadastrar(
				Voto.builder().associado(Associado.builder().id(votoDto.getIdAssociado()).build())
						.sessaoVotacao(SessaoVotacao.builder().id(votoDto.getIdSessaoVotacao()).build())
						.decisaoVoto(votoDto.getValorVoto()).build());
		response.setData(voto);
		return ResponseEntity.ok(response);
	}

	@ResponseBody
	@GetMapping(value = "/retornar/votacao/pauta{idPauta}", produces = "application/json")
	public ResponseEntity<Response<RetornoVotacaoDto>> retornaVotacaoPorPauta(@PathVariable("idPauta") Long idPauta) {
		Response<RetornoVotacaoDto> response = new Response<RetornoVotacaoDto>();
		RetornoVotacaoDto retornoVotacaoDto = votoService.retornaVotacaoPorPauta(idPauta);
		response.setData(retornoVotacaoDto);
		return ResponseEntity.ok(response);
	}

}
