package com.amstech.decoration.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("UserController : Ojject Created");
	}

	@RequestMapping(method = RequestMethod.POST,value = "/signup")
	public void SignUp() {
    System.out.println("sign up completed");
	}
}
