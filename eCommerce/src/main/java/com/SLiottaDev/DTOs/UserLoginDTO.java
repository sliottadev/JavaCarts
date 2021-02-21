package com.SLiottaDev.DTOs;

public class UserLoginDTO {
	
	private String userLogin;
	
	private String passWord;

	public UserLoginDTO() {
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
