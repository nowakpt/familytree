package pt.nowak.familytree.controller.forms;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class SignupForm {

	@Length(min = 4, max = 40)
	@NotNull
	private String username;

	@Length(min = 6, max = 60)
	@NotNull
	private String password;

	@Length(min = 6, max = 60)
	@NotNull
	private String passwordConfirm;

	@Email
	@Length(max = 50)
	@NotNull
	private String emailAddress;

	@Email
	@Length(max = 50)
	@NotNull
	private String emailAddressConfirm;


	@AssertTrue(message = "passwords must be identical")
	public boolean isPasswordConfirmed() {
		return passwordConfirm != null && passwordConfirm.equals(password); //todo check if null-comparison is required here - depends on order of assertions?
	}

	@AssertTrue(message = "email addresses must be identical")
	public boolean isEmailAddressConfirmed() {
		return emailAddressConfirm != null && emailAddressConfirm.equals(emailAddress); //todo check if null-comparison is required here - depends on order of assertions?
	}

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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddressConfirm() {
		return emailAddressConfirm;
	}

	public void setEmailAddressConfirm(String emailAddressConfirm) {
		this.emailAddressConfirm = emailAddressConfirm;
	}

	@Override
	public String toString() {
		return "SignupForm{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", passwordConfirm='" + passwordConfirm + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				", emailAddressConfirm='" + emailAddressConfirm + '\'' +
				'}';
	}
}
