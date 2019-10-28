package com.mobileappservice.model;

public class UserLoginResponse {

	private int statusCode;
	private String status;
	private String firstName;
    private String emaildID;
	private int userId;
	private String message;

    public UserLoginResponse(int userId, String emaildID, String firstName, int statusCode, String status, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.userId=userId;
		this.message = message;
		this.emaildID = emaildID;
		this.firstName = firstName;
	}

	public UserLoginResponse(int statusCode, String status, String message) {

		this.statusCode = statusCode;
		this.status = status;
		this.message = message;

	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmaildID() {
		return emaildID;
	}

	public void setEmaildID(String emaildID) {
		this.emaildID = emaildID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
