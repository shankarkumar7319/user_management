package usermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import usermanagement.service.UsersService;

@RestController
public class UsersController {

	UsersService service;

	public UsersController(UsersService service) {
		super();
		this.service = service;
	}
	
	
}
