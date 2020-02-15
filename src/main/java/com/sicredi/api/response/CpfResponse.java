package com.sicredi.api.response;

import com.sicredi.api.enums.CpfEnum;

public class CpfResponse {
	
	private CpfEnum status;
	
	public CpfResponse(CpfEnum status) {
		this.status = status;
	}

	public CpfEnum getStatus() {
		return status;
	}

	public void setStatus(CpfEnum status) {
		this.status = status;
	}
	
}
