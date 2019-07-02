package login_maven.controller;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class Login {

	@Size(min = 1, message = "User name is required")
	private String userName;

	@Size(min = 1, message = "password is required")
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
