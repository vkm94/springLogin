package com.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entity.Users;
import com.repo.UserRepo;
@Service
public class userService {
	@Autowired
UserRepo repo;
	public Users usrsave(@Valid Users user) {
		
		Users result=repo.save(user);
		return result;
		
	}
	public  ResponseEntity<Users> add( String name, String email, String password, String phoneNumber, String address,  String admin_id, String contact) {
		
		
		Users u=new Users();
	u.setName(name);
		u.setEmail(email); 
		
		u.setPassword(password);
	u.setAddress(address);
	u.setRole("user");
	u.setContact(contact);
		u.setAdmin_id(admin_id);
		return new ResponseEntity<>(repo.save(u), HttpStatus.CREATED);
		
//		Users result=repo.save(u);
		
	}
	public List<Users> getUSers(String id) {
		repo.getUsers(id);
		return repo.getUsers(id);
	}
	public String deleteUser(int id) {
		
		if(repo.findById(id) != null) {
			 repo.deleteById(id);
			 return "Error";
		}else {
			 return "Success";
		}
		
		
		
	}
	
	public List<Users> editUser(int id, Users user) {
		Users us1=repo.findById(id).orElse(null);
		us1.setName(user.getName());
		us1.setEmail(user.getEmail());
		us1.setContact(user.getContact());
		us1.setAddress(user.getAddress());
	
		repo.save(us1);
		
		
		
		return null;
	}
	public List<Users> login(String email, String password) {
		List<Users> ul=repo.Login(email,password);
		
		return ul;
	}
	public List<Users> editUser(int id) {
		
		Optional <Users>u=repo.findById(id);
		List<Users>l=	u.stream().toList();
		return l;
	}
	public Users addAdmin(String name, String email, String password, String phonenumber, String address,
			String admin_id, String contact) {
		Users u=new Users();
		u.setName(name);
			u.setEmail(email); 
			
			u.setPassword(password);
		u.setAddress(address);
		u.setRole("user");
		u.setContact(contact);
			u.setAdmin_id(admin_id);
			return repo.save(u);
		
	}
	

	

}
