package usermanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import usermanagement.dto.UsersRequestDto;
import usermanagement.dto.UsersResponseDto;
import usermanagement.entity.Users;
import usermanagement.service.UsersService;

@RestController
public class UsersController {

	UsersService service;

	public UsersController(UsersService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	String register(@RequestBody UsersRequestDto user) {
		return service.register(user);
	}
	@GetMapping("/searchUser/{id}")
	UsersRequestDto searchUser(@PathVariable Long id) {
		return service.searchUser(id);
	}
	@GetMapping("/viewAllUsers")
	List<UsersResponseDto> viewAllUsers() {
		return service.viewAllUsers();
	}
	@PutMapping("/updateUser")
	String updateUser(@RequestBody Users user) {
		return service.updateUser(user); 
	}
	@GetMapping("/deleteUser/{id}")
	String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
}
