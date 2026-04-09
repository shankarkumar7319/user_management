package usermanagement.service;

import java.util.*;

import usermanagement.dto.UsersRequestDto;
import usermanagement.dto.UsersResponseDto;
import usermanagement.entity.Users;

public interface UsersService {

	String register(UsersRequestDto user);
	UsersRequestDto searchUser(Long id);
	List<UsersResponseDto> viewAllUsers();
	String updateUser(Users user);
	String deleteUser(Long id);
	
}
