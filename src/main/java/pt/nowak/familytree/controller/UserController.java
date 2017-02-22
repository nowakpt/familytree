package pt.nowak.familytree.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pt.nowak.familytree.controller.forms.LoginForm;
import pt.nowak.familytree.controller.forms.SignupForm;

import javax.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSubmit(
			@Valid @ModelAttribute SignupForm signupForm,
			BindingResult bindingResult) {
		//todo validate form, pass to Service, check response and return next view
		LoggerFactory
				.getLogger(this.getClass())
				.info(signupForm.toString());
		return "signup";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping(path = "/login")
	public String loginSubmit(@Valid @ModelAttribute LoginForm loginForm) {
		//todo pass it to Service, check response and return dashboard view or login view with error info
		LoggerFactory
				.getLogger(this.getClass())
				.info(loginForm.toString());
		return "login";
	}


}
