package com.sicredi.api.response;

import com.sicredi.api.enums.StatusCpfEnum;

public class CpfResponse {
	
	private StatusCpfEnum status;
	
	public CpfResponse(StatusCpfEnum status) {
		this.status = status;
	}

	public StatusCpfEnum getStatus() {
		return status;
	}

	public void setStatus(StatusCpfEnum status) {
		this.status = status;
	}
	
}
