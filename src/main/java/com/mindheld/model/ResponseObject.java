package com.mindheld.model;

public class ResponseObject {

	public static final String OK_MESSAGE = "operation succesfully";
	public static final String OK = "ok";
	public static final String ERROR = "error";
	
	private String status;
	private String message;
	private Object result;

	public ResponseObject() {
	};

	public ResponseObject(String status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
