package com.cg.rebapi.exception;

public class ErrorInfo {
	
	private String id;

	public ErrorInfo() {
		super();
	}

	public ErrorInfo(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ErrorInfo [id=" + id + "]";
	}
	

	

}
