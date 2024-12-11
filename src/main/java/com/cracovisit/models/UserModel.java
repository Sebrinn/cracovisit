package com.cracovisit.models;

public class UserModel {
	
	private Long userID;
	private String userName;
	private String userLastName;
	private String userEmail;
	private String userPassword;
	private String userAccountType;
	private String userPrefferedLanguage;
	
	public UserModel(Long userID, String userName, String userLastName, String userEmail, String userPassword,
			String userAccountType, String userPrefferedLanguage) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAccountType = userAccountType;
		this.userPrefferedLanguage = userPrefferedLanguage;
	}

	public UserModel() {
		super();
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAccountType() {
		return userAccountType;
	}

	public void setUserAccountType(String userAccountType) {
		this.userAccountType = userAccountType;
	}

	public String getUserPrefferedLanguage() {
		return userPrefferedLanguage;
	}

	public void setUserPrefferedLanguage(String userPrefferedLanguage) {
		this.userPrefferedLanguage = userPrefferedLanguage;
	}

	@Override
	public String toString() {
		return "LoginModel [userID=" + userID + ", userName=" + userName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userAccountType=" + userAccountType
				+ ", userPrefferedLanguage=" + userPrefferedLanguage + "]";
	}
	
	
	
	

}
