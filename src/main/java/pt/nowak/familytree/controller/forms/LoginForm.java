package pt.nowak.familytree.controller.forms;

import javax.validation.constraints.NotNull;

public class LoginForm {

	@NotNull
	private String username;
	@NotNull
	private String password;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
