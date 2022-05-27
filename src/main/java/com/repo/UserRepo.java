package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Users;
@Repository
public interface UserRepo extends CrudRepository<Users, Integer>{

	@Query("Select u from Users u where u.admin_id=:id")
	List<Users> getUsers(String id);

	
	@Query("Select u from Users u where u.email=:email and u.password=:password")
	List<Users> Login(String email, String password);
	

	

}
