package org.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private int errorCode;
	private String errorMessage;
	private String description;

	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(int errorCode, String errorMessage, String description) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.description = description;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
