package com.devsuperior.dsclient.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> errorsFields;

    public StandardError() {

    }    

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getErrorsFields() {
		return errorsFields;
	}

	public void setErrorsFields(Map<String, String> errorsFields) {
		this.errorsFields = errorsFields;
	}
}