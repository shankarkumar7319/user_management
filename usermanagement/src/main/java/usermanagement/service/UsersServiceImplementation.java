package usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import usermanagement.dto.UsersRequestDto;
import usermanagement.dto.UsersResponseDto;
import usermanagement.entity.Users;
import usermanagement.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{

	UsersRepository repo;

	public UsersServiceImplementation(UsersRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String register(UsersRequestDto user) {
		
		if(repo.existsById(user.getId())) {
			return "User already exists";
		}
		
		Users u = new Users();
		u.setId(user.getId());
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setMobile(user.getMobile());
		u.setDob(user.getDob());
		u.setGender(user.getGender());
		u.setAddress(user.getAddress());
		u.setDpUrl(user.getDpUrl());
		
		repo.save(u);
		return "User registered successfully";
	}

	@Override
	public UsersRequestDto searchUser(Long id) {
		
	   Users u = repo.findById(id).orElse(null);
	   
	    if (u == null) return null;

	    UsersRequestDto dto = new UsersRequestDto();

	    dto.setId(u.getId());
	    dto.setUsername(u.getUsername());
	    dto.setEmail(u.getEmail());
	    // ❌ remove password
	    dto.setMobile(u.getMobile());
	    dto.setDob(u.getDob());
	    dto.setGender(u.getGender());
	    dto.setAddress(u.getAddress());
	    dto.setDpUrl(u.getDpUrl());

	    return dto;
	}

	@Override
	public List<UsersResponseDto> viewAllUsers() {
		
		List<Users> users = repo.findAll();
	     List<UsersResponseDto> dtoList = new ArrayList<>();

	        for (Users u : users) {
	        	
	        	UsersResponseDto dto = new UsersResponseDto();
	            
	            dto.setId(u.getId());
	            dto.setUsername(u.getUsername());
	            dto.setEmail(u.getEmail());
	            //dto.setPassword(u.getPassword());
	            dto.setMobile(u.getMobile());
	            dto.setDob(u.getDob());
	            dto.setGender(u.getGender());
	            dto.setAddress(u.getAddress());
	            dto.setDpUrl(u.getDpUrl());

	            dtoList.add(dto);
	        }

	        return dtoList;	
	}

	@Override
	public String updateUser(Users user) {
		
		if(!repo.existsById(user.getId())) {
			return "User not found";
		}
		
		Users u = new Users();
		
		u.setId(user.getId());
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setMobile(user.getMobile());
		u.setDob(user.getDob());
		u.setGender(user.getGender());
		u.setAddress(user.getAddress());
		u.setDpUrl(user.getDpUrl());
		
		repo.save(u);
		return "User updated successfully";
	}

	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "User deleted successfully";
	}
	
}
