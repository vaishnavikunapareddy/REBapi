package com.cg.rebapi.exception;

public class EmptyFieldException extends RuntimeException{
	private static final long serialVersionUID =1L;
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErroeMessage() {
		return errorMessage;
	}
	public void setErroeMessage(String erroeMessage) {
		this.errorMessage = erroeMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmptyFieldException(String errorCode, String erroeMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = erroeMessage;
	}
	public EmptyFieldException() {
		super();
	}

}