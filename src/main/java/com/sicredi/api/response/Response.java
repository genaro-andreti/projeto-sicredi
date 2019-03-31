package com.sicredi.api.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
	
	private T Data;
	
	private List<String> errors;

}
