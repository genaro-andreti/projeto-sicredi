package com.sicredi.api.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
	
	private T Data;
	
	private List<String> errors;
	
	public Response() {
		this.errors = CollectionUtils.isEmpty(this.errors) ? new ArrayList<String>() : this.errors;
	}

}
