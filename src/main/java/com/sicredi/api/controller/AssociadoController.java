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

import com.sicredi.api.dto.AssociadoDto;
import com.sicredi.api.dto.StatusCpf;
import com.sicredi.api.enums.StatusCpfEnum;
import com.sicredi.api.model.Associado;
import com.sicredi.api.response.Response;
import com.sicredi.api.service.AssociadoService;
import com.sicredi.api.service.SessaoVotacaoService;
import com.sicredi.api.service.ValidaCpfService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sicredi/associado")
public class AssociadoController {

	@Autowired
	private AssociadoService associadoService;
	
	@Autowired
	private ValidaCpfService validaCpfService;
	
	@Autowired
	SessaoVotacaoService sessaoVotacaoService;
	
	@ResponseBody
	@PostMapping(path = "/cadastrar", produces = "application/json")
	public ResponseEntity<Response<Associado>> cadastrar(@Valid @RequestBody AssociadoDto associadoDto, BindingResult result) {
		Response<Associado> response = new Response<Associado>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(
					error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Associado associadoCadastro = new Associado();
		associadoCadastro.setLogin(associadoDto.getLogin());
		associadoCadastro.setNome(associadoDto.getNome());
		associadoCadastro.setCpf(associadoDto.getCpf());
		associadoCadastro.setSenha(associadoDto.getSenha());
		
		try {
			
			StatusCpf statusCpf = validaCpfService.validaCpf(associadoCadastro.getCpf());
			
			if(!StatusCpfEnum.ABLE_TO_VOTE.toString().equals(statusCpf.getStatus())) {
				response.getErrors().add("Cpf inválido.");
				return ResponseEntity.badRequest().body(response);
			}
			
		} catch (Exception e) {
				response.getErrors().add("Erro ao validar cpf.");
				return ResponseEntity.badRequest().body(response);
		}
		
		Mono<Associado> retorno = associadoService.cadastrar(associadoCadastro);
		response.setData(retorno.block());
		return ResponseEntity.ok(response);
	}

}
