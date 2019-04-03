package com.sicredi.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicredi.api.dto.PautaDto;
import com.sicredi.api.model.Pauta;
import com.sicredi.api.response.Response;
import com.sicredi.api.service.PautaService;

@RestController
@RequestMapping("/sicredi/pauta")
public class PautaController {

	@Autowired
	private PautaService pautaService;

	@ResponseBody
	@PostMapping(path = "/cadastrar", produces = "application/json")
	public ResponseEntity<Response<Pauta>> cadastrar(@Valid @RequestBody PautaDto pautaDto, BindingResult result) {
		Response<Pauta> response = new Response<Pauta>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Pauta pautaCadastrada = pautaService
				.cadastrar(Pauta.builder().descricao(pautaDto.getDescricao()).build());
		response.setData(pautaCadastrada);

		return ResponseEntity.ok(response);
	}

}
