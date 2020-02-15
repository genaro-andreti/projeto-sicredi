package com.sicredi.api.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sicredi.api.enums.CpfEnum;
import com.sicredi.api.response.CpfResponse;

@Service
public class ValidaCpfService {

	public CpfResponse validaCpf(String cpf){
        RestTemplate template = new RestTemplate();
        
        try {
        	return template.getForObject("https://user-info.herokuapp.com/users/{cpf}", CpfResponse.class, cpf);
		} catch (Exception e) {
			return new CpfResponse(CpfEnum.STATUS_404);
		}
    }
}
