package com.cracovisit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table("users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("userID")
	private Long userID;
	
	@Column("userName")
	private String userName;
	
	@Column("userLastName")
	private String userLastName;
	
	@Column("userEmail")
	private String userEmail;
	
	@Column("userPassword")
	private String userPassword;
	
	@Column("userAccountType")
	private String userAccountType;
	
	@Column("userPrefferedLanguage")
	private String userPrefferedLanguage;
	
	public UserEntity(Long userID, String userName, String userLastName, String userEmail, String userPassword,
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

	public UserEntity() {
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
