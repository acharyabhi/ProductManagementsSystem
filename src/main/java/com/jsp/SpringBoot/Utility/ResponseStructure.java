package com.jsp.SpringBoot.Utility;

public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private T data;
	
	public int getStatus() {
		return status;
	}
	public ResponseStructure<T> setStatus(int status) {
		this.status = status;
		return new ResponseStructure<>();
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return new ResponseStructure<>();
	}
	public T getData() {
		return data;
	}
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return new ResponseStructure<>();
	}
	
	

}
