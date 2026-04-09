package usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import usermanagement.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
