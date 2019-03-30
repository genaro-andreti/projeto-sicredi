package com.sicredi.api.response;

import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
	
	private T Data;
	
	private Optional<List<String>> errors = Optional.empty();

}
