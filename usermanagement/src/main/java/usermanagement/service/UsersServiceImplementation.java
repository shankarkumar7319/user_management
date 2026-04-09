package usermanagement.service;

import org.springframework.stereotype.Service;

import usermanagement.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	UsersRepository repo;

	public UsersServiceImplementation(UsersRepository repo) {
		super();
		this.repo = repo;
	}
	
	
}
