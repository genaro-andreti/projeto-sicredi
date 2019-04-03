package com.sicredi.api.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.api.dto.SessaoVotacaoDto;
import com.sicredi.api.model.Pauta;
import com.sicredi.api.model.SessaoVotacao;
import com.sicredi.api.response.Response;
import com.sicredi.api.service.SessaoVotacaoService;

@RestController
@RequestMapping("/sicredi/sessaoVotacao")
public class SessaoVotacaoController {

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@ResponseBody
	@PostMapping(path = "/cadastrar", produces = "application/json")
	public ResponseEntity<Response<SessaoVotacao>> cadastrar(@Valid @RequestBody SessaoVotacaoDto sessaoVotacaoDto,
			BindingResult result) {
		Response<SessaoVotacao> response = new Response<SessaoVotacao>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		LocalDateTime dataInicio = LocalDateTime.now();
		SessaoVotacao sessaoVotacao = sessaoVotacaoService.cadastrar(SessaoVotacao.builder()
				.inicioSessaoVotacao(dataInicio).fimSessaoVotacao(sessaoVotacaoDto.dataFim(dataInicio))
				.pauta(Pauta.builder().id(sessaoVotacaoDto.getIdPauta()).build()).build());

		response.setData(sessaoVotacao);
		return ResponseEntity.ok(response);
	}

}
