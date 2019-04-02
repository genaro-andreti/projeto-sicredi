package com.sicredi.api.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> implements Serializable {
	private static final long serialVersionUID = -7891449588427949290L;

	private T Data;
	
	private List<String> errors;
	
	public Response() {
		this.errors = CollectionUtils.isEmpty(this.errors) ? new ArrayList<String>() : this.errors;
	}
	
	public Response(T data) {
		this.errors = CollectionUtils.isEmpty(this.errors) ? new ArrayList<String>() : this.errors;
		setData(data);	
	}

	public Response(T data, List<String> errors, List<String> warnings) {
		this.errors = CollectionUtils.isEmpty(this.errors) ? new ArrayList<String>() : this.errors;
		setData(data);	
		setErrors(errors);
	}

}
